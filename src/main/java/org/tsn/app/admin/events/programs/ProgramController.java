package org.tsn.app.admin.events.programs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController("/program")
public class ProgramController {

	private static final String CREATE_EVENT_PROGRAM = "";

	@Autowired
	private ProgramService service;

	@PostMapping(CREATE_EVENT_PROGRAM)
	@ApiOperation(value = "creates a event program")
	public ResponseEntity<String> createEventProgram(@RequestBody CreateEventProgramWebDTO programWebDTO) {
		service.createProgram(programWebDTO);
		return ResponseEntity.ok().body("SUCCESS");
	}

}
