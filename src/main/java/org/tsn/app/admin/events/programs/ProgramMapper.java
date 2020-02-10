package org.tsn.app.admin.events.programs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tsn.app.admin.ApplicationConstants;

@Component
public class ProgramMapper {

	public Program map(CreateEventProgramWebDTO createRequest) {
		Program program = new Program();

		program.setEventId(createRequest.getEventId());
		program.setProgramName(createRequest.getProgramName());
		program.setStatus(ProgramStatus.APPROVED.name());
		program.setProgramCategoryId(createRequest.getProgramCategoryId());
		program.setProgramDurationInMinutes(createRequest.getDurationInMinutes());
		program.setGroupName(createRequest.getGroupName());
		program.setIsGroupProgram(createRequest.getIsGroupProgram());
		program.setPrimaryContactName(createRequest.getPrimaryContactName());
		program.setPrimaryContactNumber(createRequest.getPrimaryContactNumber());
		program.setProgramOrder(createRequest.getProgramOrderInEvent());
		program.setCreatedUserName(ApplicationConstants.APPLICATION_ID);
		program.setLastUpdatedUserName(ApplicationConstants.APPLICATION_ID);

		return program;
	}

	public ProgramDTO map(Program program) {
		ProgramDTO dto = new ProgramDTO();

		dto.setEventId(program.getEventId());
		dto.setProgramName(program.getProgramName());
		dto.setStatus(program.getStatus());
		dto.setProgramCategoryId(program.getProgramCategoryId());
		dto.setProgramDurationInMinutes(program.getProgramDurationInMinutes());
		dto.setGroupName(program.getGroupName());
		dto.setIsGroupProgram(program.getIsGroupProgram());
		dto.setPrimaryContactName(program.getPrimaryContactName());
		dto.setPrimaryContactNumber(program.getPrimaryContactNumber());
		dto.setProgramOrder(program.getProgramOrder());

		return dto;
	}

	public Program map(ProgramDTO dto) {
		Program p = new Program();

		return p;
	}

	public List<ProgramDTO> map(List<Program> programs) {
		List<ProgramDTO> dtos = new ArrayList<>();
		programs.stream().forEach(pr -> dtos.add(map(pr)));
		return dtos;
	}
}
