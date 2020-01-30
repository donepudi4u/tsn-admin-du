package org.tsn.app.admin.events;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;

@Repository
public class EventJDBCRepository extends BaseJDBCRepository implements EventRepository {

	private static final String CREATE_EVENT = "";

	@Override
	public void createEvent(Event event) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("", event.getId());
		parameterSource.addValue("", event.getEventName());
		parameterSource.addValue("", event.getCreatedDateTime());
		parameterSource.addValue("", event.getCreatedUserName());
		parameterSource.addValue("", event.getEventDate());
		parameterSource.addValue("", event.getEventEndDateTime());
		parameterSource.addValue("", event.getEventStartDateTime());
		parameterSource.addValue("", event.getLastUpdatedDateTime());
		parameterSource.addValue("", event.getLastUpdatedUserName());
		parameterSource.addValue("", event.getLocationAddress());

		int createEvent = namedParameterJdbcTemplate.update(CREATE_EVENT, parameterSource);

	}

}
