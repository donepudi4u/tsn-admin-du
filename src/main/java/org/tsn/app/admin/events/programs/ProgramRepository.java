package org.tsn.app.admin.events.programs;

import java.util.List;

public interface ProgramRepository {

	void createProgram(Program program);

	List<Program> getAllProgramsByEventId(Long eventId);
}
