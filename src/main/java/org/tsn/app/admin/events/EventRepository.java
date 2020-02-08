package org.tsn.app.admin.events;

import java.util.List;

public interface EventRepository {

	void createEvent(Event event);

	List<Event> findEvents(List<String> statuses);

	void updateEventStatus(Long eventId, String name);

	void updateEvent(Event event);

	Event getEventById(Long eventId);
}
