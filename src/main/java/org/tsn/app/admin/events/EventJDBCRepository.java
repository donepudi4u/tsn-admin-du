package org.tsn.app.admin.events;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;

@Repository
public class EventJDBCRepository extends BaseJDBCRepository implements EventRepository {

	private static final String CREATE_EVENT = "insert into tsn_evnt(evnt_name, evnt_date, evnt_strt_time ,evnt_end_time, evnt_loc, evnt_crtd_by , evnt_crtd_dt ,evnt_last_updt_by ,evnt_last_uptd_dt ) "
			+ " values(:eventName,:evntDate,:eventStartTime,:eventEndTime,:eventLocation,:eventCreatedBy,now(),:eventLastUpdatedBy,now())";

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

}
