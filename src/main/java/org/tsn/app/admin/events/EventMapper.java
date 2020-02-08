package org.tsn.app.admin.events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class EventMapper {

	public Event map(CreateEventWebDTO eventWebDTO) {
		Event event = new Event();
		event.setEventName(eventWebDTO.getEventName());
		event.setEventDate(eventWebDTO.getEventDate());
		event.setEventStartDateTime(eventWebDTO.getEventStartDateTime());
		event.setEventEndDateTime(eventWebDTO.getEventEndDateTime());
		event.setLocationAddress(eventWebDTO.getLocationAddress());
		return event;
	}

	public EventDTO map(Event event) {
		EventDTO dto = new EventDTO();
		dto.setEventName(event.getEventName());
		dto.setEventDate(event.getEventDate());
		dto.setEventStartDateTime(event.getEventStartDateTime());
		dto.setEventEndDateTime(event.getEventEndDateTime());
		dto.setLocationAddress(event.getLocationAddress());
		return dto;
	}

	public List<EventDTO> map(List<Event> events) {

		if (CollectionUtils.isEmpty(events)) {
			return new ArrayList<EventDTO>();
		}

		List<EventDTO> eventDTOs = new ArrayList<>();

		events.stream().forEach(event -> {
			eventDTOs.add(map(event));
		});

		return eventDTOs;
	}

}
