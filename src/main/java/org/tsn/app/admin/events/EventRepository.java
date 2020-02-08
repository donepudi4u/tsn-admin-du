package org.tsn.app.admin.events;

import java.util.List;

public interface EventRepository {

	void createEvent(Event event);

	List<Event> findEvents(Boolean includeInActive);
}
