package org.tsn.app.admin.events.programs.participants;

import java.util.List;

public interface PartcipantService {

	void createParticipant(Long programId,List<ParticipantDTO> dtos);

}
