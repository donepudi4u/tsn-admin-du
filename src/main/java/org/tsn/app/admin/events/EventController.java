package org.tsn.app.admin.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/events")
public class EventController {

	private static final String CREATE_EVENT = "/create-event";
	private static final String FIND_EVENTS = "/find-events";

	@Autowired
	private EventService eventService;

	@PostMapping(CREATE_EVENT)
	@ApiOperation(value = "Creates a new event.")
	public void createEvent(@RequestBody CreateEventWebDTO createEventDTO) {
		eventService.createEvent(createEventDTO);
	}

	@GetMapping(FIND_EVENTS)
	@ApiOperation(value = "get all events.")
	public void findEvents(@RequestParam Boolean includeInActive) {
		ResponseEntity<List<EventDTO>> responseEntity = new ResponseEntity<>();

		List<EventDTO> events = eventService.findEvents(includeInActive);
	}

}
