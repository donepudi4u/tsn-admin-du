package org.tsn.app.admin.events;

import java.util.List;

public interface EventService {

	void createEvent(CreateEventWebDTO createEventWebDTO);

	List<EventDTO> findEventsByStatus(List<EventStatus> statusList);

	void updateEventStatus(Long eventId, EventStatus status);

	void updateEvent(EventDTO eventDTO);

	EventDTO getEventById(Long eventId);
	
	
	
}
