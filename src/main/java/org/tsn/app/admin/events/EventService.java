package org.tsn.app.admin.events;

import java.util.List;

public interface EventService {

	void createEvent(CreateEventWebDTO createEventWebDTO);

	List<EventDTO> findEvents(Boolean includeInActive);
	
}
