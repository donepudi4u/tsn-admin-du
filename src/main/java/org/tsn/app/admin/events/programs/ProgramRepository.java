package org.tsn.app.admin.events.programs;

import java.util.List;

public interface ProgramRepository {

	Long createProgram(Program program);

	List<Program> getAllProgramsByEventId(Long eventId);

	void updateProgram(Program program);
}
