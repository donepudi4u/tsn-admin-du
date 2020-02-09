package org.tsn.app.admin.events.programs.participants;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;

@Repository
public class ParticipantJDBCReposiroty extends BaseJDBCRepository implements ParticipantRepository {

	@Override
	public void createProgramParticipant(List<Participant> dto) {

	}

}
