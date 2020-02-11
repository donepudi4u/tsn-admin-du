package org.tsn.app.admin.events.programs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;
import org.tsn.app.admin.util.SqlUtil;

@Repository
public class ProgramJDBCRepository extends BaseJDBCRepository implements ProgramRepository {

	private static final String CREATE_PROGRAM = " insert into tsn_evnt_prg (evnt_id, prg_name,prg_stat,prg_ctgy_id, prg_dur_in_min, is_grp_prog, "
			+ "grp_name, prg_prim_cnct_name, prg_prim_cnct_num, prg_evnt_ordr, crtn_dt, crtn_by, last_uptd_by, last_uptd_dt) "
			+ " values (:eventId,:programName,:status,:categoryId,:duration,:isGroupProgram,:groupName,:contactName,:contactNumber,"
			+ ":programOrder,now(),:createdUser,:lastUpdatedUser,now())";

	private static final String UPDATE_PROGRAM = 
		" update tsn_evnt_prg  set  evnt_id=:eventId,  prg_name= :programName, "+
			" prg_stat=:status, prg_ctgy_id=:categoryId,  prg_dur_in_min=:duration,  is_grp_prog=:isGroupProgram,  "+
			" grp_name=:groupName, prg_prim_cnct_name=:contactName, prg_prim_cnct_num =:contactNumber, "+
			" prg_evnt_ordr = :programOrder, last_uptd_by = :lastUpdatedUser, last_uptd_dt=now() "+
			" where prg_id = :programId";

	private static final String GET_PROGRAMS_BY_EVENT_ID = "select * from tsn_evnt_prg";

	@Override
	public Long createProgram(Program program) {
		MapSqlParameterSource parameterSource = buildProgramParameters(program);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(CREATE_PROGRAM, parameterSource, keyHolder);
		return keyHolder.getKey().longValue();
	}

	private MapSqlParameterSource buildProgramParameters(Program program) {
		MapSqlParameterSource pararmSource = new MapSqlParameterSource();

		pararmSource.addValue("eventId", program.getEventId());
		pararmSource.addValue("programName", program.getProgramName());
		pararmSource.addValue("status", program.getStatus());
		pararmSource.addValue("categoryId", program.getProgramCategoryId());
		pararmSource.addValue("duration", program.getProgramDurationInMinutes());
		pararmSource.addValue("isGroupProgram", program.getIsGroupProgram());
		pararmSource.addValue("groupName", program.getGroupName());
		pararmSource.addValue("contactName", program.getPrimaryContactName());
		pararmSource.addValue("contactNumber", program.getPrimaryContactNumber());
		pararmSource.addValue("programOrder", program.getProgramOrder());
		pararmSource.addValue("lastUpdatedUser", program.getLastUpdatedUserName());
		pararmSource.addValue("createdUser", program.getCreatedUserName());

		return pararmSource;
	}

	@Override
	public List<Program> getAllProgramsByEventId(Long eventId) {
		return jdbcTemplate.query(GET_PROGRAMS_BY_EVENT_ID, new Object[]{eventId} , new RowMapper<Program>() {
			
			@Override
			public Program mapRow(ResultSet rs, int row) throws SQLException {
				Program program = new Program();
				program.setId(rs.getLong(""));
				program.setCreatedDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("crtn_dt")));
				program.setCreatedUserName(rs.getString("crtn_by"));
				program.setEventId(rs.getLong("evnt_id"));
				program.setGroupName(rs.getString("grp_name"));
				program.setIsGroupProgram(SqlUtil.convertToBoolean(rs.getString("is_grp_prog")));
				program.setLastUpdatedDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("last_uptd_dt")));
				program.setLastUpdatedUserName(rs.getString("last_uptd_by"));
				program.setPrimaryContactName(rs.getString("prg_prim_cnct_name"));
				program.setPrimaryContactNumber(rs.getString("prg_prim_cnct_num"));
				program.setProgramCategoryId(rs.getLong("prg_ctgy_id"));
				program.setProgramDurationInMinutes(rs.getInt("prg_dur_in_min"));
				program.setProgramName(rs.getString("prg_name"));
				program.setProgramOrder(rs.getInt("prg_evnt_ordr"));
				program.setStatus(rs.getString("prg_stat"));
				
				return program;
			}
		});
		
	}

	@Override
	public void updateProgram(Program r) {
		MapSqlParameterSource p = buildProgramParameters(r);
		p.addValue("programId", r.getId());
		namedParameterJdbcTemplate.update(UPDATE_PROGRAM, p);
		System.out.println("Program Updated successfully");
	}

}
