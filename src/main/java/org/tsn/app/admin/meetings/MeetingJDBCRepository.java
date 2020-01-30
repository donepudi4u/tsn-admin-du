package org.tsn.app.admin.meetings;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.tsn.app.admin.base.BaseJDBCRepository;

public class MeetingJDBCRepository extends BaseJDBCRepository implements MeetingRepository {

	private static final String CREATE_MEETING = "";

	@Override
	public void createMeeting(Meeting meeting) {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("", meeting.getSubject());
		ps.addValue("", meeting.getCreatedDateTime());
		ps.addValue("", meeting.getCreatedUserName());
		ps.addValue("", meeting.getLastUpdatedDateTime());
		ps.addValue("", meeting.getLastUpdatedUserName());
		ps.addValue("", meeting.getMeetingAgenda());
		ps.addValue("", meeting.getMeetingStartDateTime());
		ps.addValue("", meeting.getMeetingEndDateTime());
		ps.addValue("", meeting.getStatus());

		namedParameterJdbcTemplate.update(CREATE_MEETING, ps);

	}

	class MeetingResultSetExtractor implements ResultSetExtractor<Meeting> {

		@Override
		public Meeting extractData(ResultSet arg0) throws SQLException, DataAccessException {

			return null;
		}

	}
}
