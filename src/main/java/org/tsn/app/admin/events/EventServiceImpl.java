package org.tsn.app.admin.events;

import java.util.ArrayList;
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
		Event event = mapper.map(createEventWebDTO);
		event.setEventStatus(EventStatus.NEW.name());
		repository.createEvent(event);

	}

	@Override
	public List<EventDTO> findEventsByStatus(List<EventStatus> status) {
		List<String> statusList = new ArrayList<>();
		
		status.stream().forEach(s -> statusList.add(s.name()));
		List<Event> events = repository.findEvents(statusList);
		return mapper.map(events);
	}

	@Override
	public void updateEventStatus(Long eventId, EventStatus status) {
		
		repository.updateEventStatus(eventId,status.name());
		
	}

	@Override
	public void updateEvent(EventDTO eventDTO) {
		 repository.updateEvent(mapper.map(eventDTO));
	}

	@Override
	public EventDTO getEventById(Long eventId) {
		Event event = repository.getEventById(eventId);
		return mapper.map(event);
	}

}
