package org.tsn.app.admin.events.programs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsn.app.admin.events.programs.participants.PartcipantService;

@Service
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramRepository repository;

	@Autowired
	private ProgramMapper mapper;
	
	@Autowired
	private PartcipantService participantService;  

	@Override
	public void createProgram(CreateEventProgramWebDTO programWebDTO) {
		Long programId = repository.createProgram(mapper.map(programWebDTO));
		System.out.println("Program number created : " + programId);
		participantService.createParticipant(programId,programWebDTO.getParticipants());
		
	}

	@Override
	public List<ProgramDTO> getAllProgramsByEventId(Long eventId) {

		List<Program> programs = repository.getAllProgramsByEventId(eventId);
		return mapper.map(programs);
	}

	@Override
	public void updateProgram(ProgramDTO programDTO) {
		repository.updateProgram(mapper.map(programDTO));
		
	}

}
