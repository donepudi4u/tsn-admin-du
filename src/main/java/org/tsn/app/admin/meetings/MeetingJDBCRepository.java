package org.tsn.app.admin.meetings;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;

@Repository
public class MeetingJDBCRepository extends BaseJDBCRepository implements MeetingRepository {

	private static final String CREATE_MEETING = 
			" insert tsn.tsn_mtng(mtng_name,mtng_date,mtng_crtd_by,mtng_crtd_dt,mtng_last_uptd_dt,mtng_last_updt_by,mtng_strt_time,mtng_end_time,mtng_status) "
					+ " values (:name,sysdate(),:createdBy,:createdDateTime,sysdate(),:lastUpdatedBy,:startTime,:endTime,:meetingStatus)";

	@Override
	public void createMeeting(Meeting meeting) {
		
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("name", meeting.getSubject());
		ps.addValue("createdBy", meeting.getCreatedUserName());
		ps.addValue("createdDateTime", meeting.getCreatedDateTime());
		ps.addValue("lastUpdatedDate", meeting.getLastUpdatedDateTime());
		ps.addValue("lastUpdatedBy", meeting.getLastUpdatedUserName());
		ps.addValue("startTime", meeting.getMeetingStartDateTime());
		ps.addValue("endTime", meeting.getMeetingEndDateTime());
		ps.addValue("meetingStatus", meeting.getStatus());

		namedParameterJdbcTemplate.update(CREATE_MEETING, ps);

	}

	class MeetingResultSetExtractor implements ResultSetExtractor<Meeting> {

		@Override
		public Meeting extractData(ResultSet arg0) throws SQLException, DataAccessException {

			return null;
		}

	}
}
