package org.tsn.app.admin.events;

import org.springframework.stereotype.Component;

@Component
public class EventMapper {

	
	public Event map(CreateEventWebDTO eventWebDTO){
		Event event = new Event();
		event.setEventName(eventWebDTO.getEventName());
		event.setEventDate(eventWebDTO.getEventDate());
		event.setEventStartDateTime(eventWebDTO.getEventStartDateTime());
		event.setEventEndDateTime(eventWebDTO.getEventEndDateTime());
		event.setLocationAddress(eventWebDTO.getLocationAddress());
		return event;
	}
	
}
