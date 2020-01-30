package org.tsn.app.admin.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

	private static final String CREATE_EVENT = "/create-event";
	
	@Autowired
	private EventService eventService;
	
	@PostMapping(CREATE_EVENT)
	public void createEvent(@RequestBody CreateEventWebDTO createEventDTO){
		eventService.createEvent(createEventDTO);
	}
	
}
