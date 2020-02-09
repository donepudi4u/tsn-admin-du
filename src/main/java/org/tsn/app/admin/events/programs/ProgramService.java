package org.tsn.app.admin.events.programs;

import java.util.List;

public interface ProgramService {

	void createProgram(CreateEventProgramWebDTO programWebDTO);

	List<ProgramDTO> getAllProgramsByEventId(Long eventId);

	
}
