package org.tsn.app.admin.events;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;
import org.tsn.app.admin.util.SqlUtil;

@Repository
public class EventJDBCRepository extends BaseJDBCRepository implements EventRepository {

	private static final String CREATE_EVENT = "insert into tsn_evnt(evnt_name, evnt_date, evnt_strt_time ,evnt_end_time, evnt_loc, evnt_crtd_by , evnt_crtd_dt ,evnt_last_updt_by ,evnt_last_uptd_dt ) "
			+ " values(:eventName,:evntDate,:eventStartTime,:eventEndTime,:eventLocation,:eventCreatedBy,now(),:eventLastUpdatedBy,now())";

	private static final String FIND_EVENTS_BASE = "SELECT * FROM TSN.TSN_EVNT";
	private static final String FIND_ACTIVE_EVENTS = FIND_EVENTS_BASE + DEFAULT_WHERE + " and evnt_stat =:status ";

	@Override
	public void createEvent(Event event) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("eventName", event.getEventName());
		parameterSource.addValue("eventCreatedBy", event.getCreatedUserName());
		parameterSource.addValue("evntDate", event.getEventDate());
		parameterSource.addValue("eventEndTime", event.getEventEndDateTime());
		parameterSource.addValue("eventStartTime", event.getEventStartDateTime());
		parameterSource.addValue("eventLastUpdatedBy", event.getLastUpdatedUserName());
		parameterSource.addValue("eventLocation", event.getLocationAddress());

		int eventId = namedParameterJdbcTemplate.update(CREATE_EVENT, parameterSource);
		System.out.println("Event created successfulyy : id generated :" + eventId);

	}

	@Override
	public List<Event> findEvents(Boolean includeInActive) {
		return jdbcTemplate.query(FIND_EVENTS_BASE, new RowMapper<Event>() {

			@Override
			public Event mapRow(ResultSet rs, int row) throws SQLException {
				Event event = new Event();
				event.setEventName(rs.getString("evnt_name"));
				event.setEventDate(rs.getDate("evnt_date"));
				event.setEventStartDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_strt_time")));
				event.setEventEndDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_end_time")));
				event.setLocationAddress(rs.getString("evnt_loc"));
				return event;
			}
		});
	}

}
