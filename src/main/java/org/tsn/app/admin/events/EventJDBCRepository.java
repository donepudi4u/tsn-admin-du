package org.tsn.app.admin.events;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.ApplicationConstants;
import org.tsn.app.admin.base.BaseJDBCRepository;
import org.tsn.app.admin.util.SqlUtil;

@Repository
public class EventJDBCRepository extends BaseJDBCRepository implements EventRepository {

	private static final String CREATE_EVENT = "insert into tsn_evnt(evnt_name, evnt_date, evnt_strt_time ,evnt_end_time, evnt_loc, evnt_crtd_by , evnt_crtd_dt ,evnt_last_updt_by ,evnt_last_uptd_dt,evnt_stat ) "
			+ " values(:eventName,:evntDate,:eventStartTime,:eventEndTime,:eventLocation,:eventCreatedBy,now(),:eventLastUpdatedBy,now(),:eventStatus)";

	private static final String FIND_EVENTS_BASE = "SELECT * FROM TSN.TSN_EVNT";
	private static final String FIND_EVENTS_BY_STATUS = FIND_EVENTS_BASE + DEFAULT_WHERE + " and evnt_stat in(:status)";

	private static final String UPDATE_EVENT_STATUS_BY_ID = "UPDATE TSN.TSN_EVNT TE SET TE.EVNT_STAT = :eventStatus , te.evnt_last_updt_by = :lastUpdatedBy, te.evnt_last_uptd_dt = now() WHERE TE.EVNT_ID = :eventId";

	private static final String UPDATE_EVENT = "update tsn.tsn_evnt te set te.evnt_name = :eventName , te.evnt_date = :eventDate , te.evnt_strt_time = :eventStartTime , te.evnt_end_time = :eventEndTime , te.evnt_loc = :eventLocation ,"
			+ " te.evnt_last_updt_by = :eventLastUpdatedBy , evnt_last_uptd_dt = now() ,evnt_stat =:eventStatus where te.evnt_id =:eventId";

	private static final String GET_EVENT_BY_ID = FIND_EVENTS_BASE + DEFAULT_WHERE + " and EVNT_ID = ?";

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
		parameterSource.addValue("eventStatus", event.getEventStatus());

		int eventId = namedParameterJdbcTemplate.update(CREATE_EVENT, parameterSource);
		System.out.println("Event created successfulyy : id generated :" + eventId);

	}

	@Override
	public List<Event> findEvents(List<String> statuses) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("status", statuses);
		return namedParameterJdbcTemplate.query(FIND_EVENTS_BY_STATUS, parameterSource, new RowMapper<Event>() {

			@Override
			public Event mapRow(ResultSet rs, int row) throws SQLException {
				Event event = new Event();
				event.setId(rs.getLong("evnt_id"));
				event.setEventStatus(rs.getString("evnt_stat"));
				event.setEventName(rs.getString("evnt_name"));
				event.setEventDate(rs.getDate("evnt_date"));
				event.setEventStartDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_strt_time")));
				event.setEventEndDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_end_time")));
				event.setLocationAddress(rs.getString("evnt_loc"));
				event.setLastUpdatedUserName(rs.getString("evnt_last_updt_by"));
				event.setLastUpdatedDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_last_uptd_dt")));
				event.setCreatedUserName(rs.getString("evnt_crtd_by"));
				event.setCreatedDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_crtd_dt")));
				return event;
			}
		});
	}

	@Override
	public void updateEventStatus(Long eventId, String status) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("eventId", eventId);
		parameterSource.addValue("eventStatus", status);
		parameterSource.addValue("lastUpdatedBy", ApplicationConstants.APPLICATION_ID);

		namedParameterJdbcTemplate.update(UPDATE_EVENT_STATUS_BY_ID, parameterSource);

	}

	@Override
	public void updateEvent(Event event) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		parameterSource.addValue("eventId", event.getId());
		parameterSource.addValue("eventName", event.getEventName());
		parameterSource.addValue("eventDate", event.getEventDate());
		parameterSource.addValue("eventStartTime", event.getEventStartDateTime());
		parameterSource.addValue("eventEndTime", event.getEventEndDateTime());
		parameterSource.addValue("eventLastUpdatedBy", event.getLastUpdatedUserName());
		parameterSource.addValue("eventLocation", event.getLocationAddress());
		parameterSource.addValue("eventStatus", event.getEventStatus());

		namedParameterJdbcTemplate.update(UPDATE_EVENT, parameterSource);

	}

	@Override
	public Event getEventById(Long eventId) {
		return jdbcTemplate.queryForObject(GET_EVENT_BY_ID, new Object[]{eventId}, new RowMapper<Event>() {

			@Override
			public Event mapRow(ResultSet rs, int row) throws SQLException {
				Event event = new Event();
				event.setId(rs.getLong("evnt_id"));
				event.setEventName(rs.getString("evnt_name"));
				event.setEventDate(rs.getDate("evnt_date"));
				event.setEventStartDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_strt_time")));
				event.setEventEndDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_end_time")));
				event.setEventStatus(rs.getString("evnt_stat"));
				event.setLocationAddress(rs.getString("evnt_loc"));
				event.setCreatedUserName(rs.getString("evnt_crtd_by"));
				event.setCreatedDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_crtd_dt")));
				event.setLastUpdatedUserName(rs.getString("evnt_last_updt_by"));
				event.setLastUpdatedDateTime(SqlUtil.convertToLocalDateTime(rs.getTimestamp("evnt_last_uptd_dt")));
				return event;
			}
		});
	}

}
