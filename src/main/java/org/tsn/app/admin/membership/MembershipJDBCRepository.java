package org.tsn.app.admin.membership;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tsn.app.admin.ApplicationConstants;
import org.tsn.app.admin.base.BaseJDBCRepository;
import org.tsn.app.admin.util.SqlUtil;

@Repository
@Transactional
public class MembershipJDBCRepository extends BaseJDBCRepository implements MemberRepository {

	private static final String INSERT_MEMBER = "insert into tsn_mbr(mbr_name, mbr_email, mbr_cntc_nbr, mbr_type_id, mbr_stat, crtn_dt, crtn_by, last_uptd_by, last_uptd_dt,join_dt)"
			+ " values(:name,:email,:contactNbr,:memberTypeId,:status,now(),:createdBy,:updatedBy,now(),now())";

	private static final String FIND_MEMBER_LIKE = "select * from tsn_mbr tm"
			+ " inner join tsn_mbr_type tmt on  tm.mbr_type_id = tmt.mbr_type_id"
			+ " where tm.mbr_id like :searchTerm or tm.mbr_email like :searchTerm or tm.mbr_name like :searchTerm or tm.mbr_cntc_nbr like :searchTerm";

	@Override
	public void createMember(TSNMember member) {
		MapSqlParameterSource paramSource = buildParameters(member);
		KeyHolder holder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(INSERT_MEMBER, paramSource,holder);
		System.out.println("Successfully inserted with id :" + holder.getKey().longValue());

	}

	private MapSqlParameterSource buildParameters(TSNMember m) {
		MapSqlParameterSource p = new MapSqlParameterSource();

		p.addValue("name", m.getName());
		p.addValue("email", m.geteMail());
		p.addValue("contactNbr", m.getContactNumber());
		p.addValue("memberTypeId", m.getMemberShipTypeId());
		p.addValue("status", m.getStatus());
		p.addValue("createdBy", ApplicationConstants.APPLICATION_ID);
		p.addValue("updatedBy", ApplicationConstants.APPLICATION_ID);
		return p;
	}

	@Override
	public List<TSNMember> findMembersLike(String searchTerm) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("searchTerm", "%"+searchTerm+"%");

		return namedParameterJdbcTemplate.query(FIND_MEMBER_LIKE, paramSource, new RowMapper<TSNMember>() {

			@Override
			public TSNMember mapRow(ResultSet rs, int num) throws SQLException {
				TSNMember member = new TSNMember();

				member.setId(rs.getLong("mbr_id"));
				member.setName(rs.getString("mbr_name"));
				member.setMembershipType(rs.getString("mbr_type"));
				member.seteMail(rs.getString("mbr_email"));
				member.setContactNumber(rs.getString("mbr_cntc_nbr"));
				member.setLastUpdatedUserName(rs.getString("last_uptd_by"));
				member.setCreatedUserName(rs.getString("crtn_by"));
				member.setCreatedDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("crtn_dt")));
				member.setLastUpdatedDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("last_uptd_dt")));
				member.setTsnJoinedDate(SqlUtil.convertToLocalDateTime(rs.getTimestamp("join_dt")));

				return member;
			}
		});
	}
}
