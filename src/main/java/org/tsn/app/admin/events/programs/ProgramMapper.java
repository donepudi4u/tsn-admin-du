package org.tsn.app.admin.events.programs;

import org.springframework.stereotype.Component;

@Component
public class ProgramMapper {

	public Program map(CreateEventProgramWebDTO createRequest) {
		Program program = new Program();
		program.setEventId(createRequest.getEventId());
		program.setProgramName(createRequest.getProgramName());
		program.setProgramCategoryId(createRequest.getProgramCategoryId());
		program.setProgramDurationInMinutes(createRequest.getDurationInMinutes());
		program.setGroupName(createRequest.getGroupName());
		program.setIsGroupProgram(createRequest.getIsGroupProgram());
		program.setPrimaryContactName(createRequest.getPrimaryContactName());
		program.setPrimaryContactNumber(createRequest.getPrimaryContactNumber());
		program.setProgramOrder(createRequest.getProgramOrderInEvent());

		return program;
	}

	public ProgramDTO map(Program program) {
		ProgramDTO dto = new ProgramDTO();

		return dto;
	}

	public Program map(ProgramDTO dto) {
		Program p = new Program();

		return p;
	}
}
