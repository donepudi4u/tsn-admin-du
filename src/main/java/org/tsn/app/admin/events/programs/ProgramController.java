package org.tsn.app.admin.events.programs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProgramController {

	private static final String CREATE_EVENT_PROGRAM = "/create-event-program";

	private static final String GET_ALL_EVENT_PROGRAMS = "/get-all-event-programs/{eventId}";

	@Autowired
	private ProgramService service;

	@PostMapping(CREATE_EVENT_PROGRAM)
	@ApiOperation(value = "creates a event program")
	public ResponseEntity<String> createEventProgram(@RequestBody CreateEventProgramWebDTO programWebDTO) {
		service.createProgram(programWebDTO);
		return ResponseEntity.ok().body("SUCCESS");
	}

	@GetMapping(GET_ALL_EVENT_PROGRAMS)
	@ApiOperation(value = "creates a event program")
	public ResponseEntity<List<ProgramDTO>> getAllEventPrograms(@PathVariable Long eventId) {
		List<ProgramDTO> eventPrograms = service.getAllProgramsByEventId(eventId);
		return ResponseEntity.ok().body(eventPrograms);
	}

}
