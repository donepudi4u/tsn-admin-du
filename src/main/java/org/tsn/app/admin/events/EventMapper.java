package org.tsn.app.admin.events;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.tsn.app.admin.ApplicationConstants;

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

	public Event map(EventDTO dto) {
		Event event = new Event();
		event.setId(dto.getId());
		event.setEventName(dto.getEventName());
		event.setEventDate(dto.getEventDate());
		event.setEventStartDateTime(dto.getEventStartDateTime());
		event.setEventEndDateTime(dto.getEventEndDateTime());
		event.setLocationAddress(dto.getLocationAddress());
		event.setEventStatus(dto.getStatus());
		event.setLastUpdatedUserName(ApplicationConstants.APPLICATION_ID);
		return event;
	}
	
	public EventDTO map(Event event) {
		EventDTO dto = new EventDTO();
		dto.setId(event.getId());
		dto.setEventName(event.getEventName());
		dto.setEventDate(event.getEventDate());
		dto.setEventStartDateTime(event.getEventStartDateTime());
		dto.setEventEndDateTime(event.getEventEndDateTime());
		dto.setLocationAddress(event.getLocationAddress());
		dto.setCreatedUser(event.getCreatedUserName());
		dto.setCreatedDateTime(event.getCreatedDateTime());
		dto.setLastUpdatedUser(event.getLastUpdatedUserName());
		dto.setLastUpdatedDateTime(event.getLastUpdatedDateTime());
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
