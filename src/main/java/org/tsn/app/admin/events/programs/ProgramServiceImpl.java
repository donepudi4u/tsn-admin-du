package org.tsn.app.admin.events.programs;

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
	
}
