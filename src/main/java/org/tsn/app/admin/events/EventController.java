package org.tsn.app.admin.events;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

	private static final String CREATE_EVENT = "/create-event";
	
	
	@PostMapping(CREATE_EVENT)
	public void createEvent(@RequestBody CreateEventWebDTO createEventDTO){
		
		
	}
	
}
