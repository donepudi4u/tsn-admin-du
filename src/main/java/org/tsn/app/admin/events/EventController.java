package org.tsn.app.admin.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private static final String UPDATE_EVENT = "/update-event";
	private static final String UPDATE_EVENT_STATUS = "/update-event-status/{eventId}/{status}";
	private static final String GET_EVENT_BY_ID = "/get-event/{eventId}";

	@Autowired
	private EventService eventService;

	@PostMapping(CREATE_EVENT)
	@ApiOperation(value = "Creates a new event.")
	public void createEvent(@RequestBody CreateEventWebDTO createEventDTO) {
		eventService.createEvent(createEventDTO);
	}

	@GetMapping(FIND_EVENTS)
	@ApiOperation(value = "get all events.")
	public ResponseEntity<List<EventDTO>> findEvents(@RequestParam List<EventStatus> statusList) {
		List<EventDTO> events = eventService.findEventsByStatus(statusList);
		return ResponseEntity.ok().body(events);
	}

	@GetMapping(GET_EVENT_BY_ID)
	@ApiOperation(value = "get event details by ID.")
	public ResponseEntity<EventDTO> getEventDetails(@PathVariable Long eventId) {
		EventDTO event = eventService.getEventById(eventId);
		return ResponseEntity.ok().body(event);
	}

	@PostMapping(UPDATE_EVENT)
	@ApiOperation(value = "update event status by Id.")
	public ResponseEntity<String> updateEvent(@RequestBody EventDTO eventDTO) {
		eventService.updateEvent(eventDTO);
		return ResponseEntity.ok().body("SUCCESS");
	}
	
	@PostMapping(UPDATE_EVENT_STATUS)
	@ApiOperation(value = "update event status by Id.")
	public ResponseEntity<String> updateEventStatus(@PathVariable Long eventId,@PathVariable EventStatus status) {
		eventService.updateEventStatus(eventId,status);
		return ResponseEntity.ok().body("SUCCESS");
	}


}
