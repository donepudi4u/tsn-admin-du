package org.tsn.app.admin.events.programs.participants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

	public Participant map(ParticipantDTO dto) {
		Participant participant = new Participant();
		participant.setName(dto.getParentName());
		participant.setAge(dto.getAge());
		participant.setGender(dto.getGender().name());
		participant.setContactNumber(dto.getContactNumber());
		participant.setContactEmail(dto.getContactEmail());
		participant.setAlternativeNumber(dto.getAlternativeNumber());
		participant.setProgramId(dto.getProgramId());
		participant.setParentName(dto.getParentName());
		participant.setCreatedUserName(dto.getCreatedUser());
		participant.setLastUpdatedUserName(dto.getLastUpdatedUser());

		return participant;
	}

	public List<Participant> map(List<ParticipantDTO> dtos) {
		List<Participant> participants = new ArrayList<>();
		dtos.stream().forEach(dto -> participants.add(map(dto)));
		return participants;
	}

	public ParticipantDTO map(Participant participant) {
		ParticipantDTO dto = new ParticipantDTO();
		dto.setName(participant.getParentName());
		dto.setAge(participant.getAge());
		dto.setGender(GenderType.valueOf(participant.getGender()));
		dto.setContactNumber(participant.getContactNumber());
		dto.setContactEmail(participant.getContactEmail());
		dto.setAlternativeNumber(participant.getAlternativeNumber());
		dto.setProgramId(participant.getProgramId());
		dto.setParentName(participant.getParentName());
		dto.setCreatedUser(participant.getCreatedUserName());
		dto.setLastUpdatedUser(participant.getLastUpdatedUserName());

		return dto;
	}
}
