package org.tsn.app.admin.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventMapper mapper;

	@Autowired
	private EventRepository repository;

	@Override
	public void createEvent(CreateEventWebDTO createEventWebDTO) {

		repository.createEvent(mapper.map(createEventWebDTO));

	}

	@Override
	public List<EventDTO> findEvents(Boolean includeInActive) {
		List<Event> events = repository.findEvents(includeInActive);
		return mapper.map(events);
	}

}
