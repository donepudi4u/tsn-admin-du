package org.tsn.app.admin.events.programs.participants;

import java.util.List;

public interface ParticipantRepository {

	public void createProgramParticipant(List<Participant> dto);

}
