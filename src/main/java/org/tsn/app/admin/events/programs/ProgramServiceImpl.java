package org.tsn.app.admin.events.programs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramRepository repository;

	@Autowired
	private ProgramMapper mapper;

	@Override
	public void createProgram(CreateEventProgramWebDTO programWebDTO) {
		repository.createProgram(mapper.map(programWebDTO));
	}

	@Override
	public List<ProgramDTO> getAllProgramsByEventId(Long eventId) {

		List<Program> programs = repository.getAllProgramsByEventId(eventId);
		return mapper.map(programs);
	}

}
