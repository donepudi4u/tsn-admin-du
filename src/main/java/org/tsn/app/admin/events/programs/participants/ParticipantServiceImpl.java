package org.tsn.app.admin.events.programs.participants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements PartcipantService {

	@Autowired
	private ParticipantMapper mapper;
	
	@Autowired
	private ParticipantRepository repository;
	
	@Override
	public void createParticipant(List<ParticipantDTO> dtos) {
		repository.createProgramParticipant(mapper.map(dtos));
	}

}
