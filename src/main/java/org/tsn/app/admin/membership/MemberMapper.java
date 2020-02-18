package org.tsn.app.admin.membership;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

	public TSNMember map(CreateTSNMemberDTO dto) {
		TSNMember member = new TSNMember();
		member.setName(dto.getName());
		member.seteMail(dto.geteMail());
		member.setContactNumber(dto.getContactNumber());
		member.setTsnJoinedDate(LocalDateTime.now());
		member.setMemberShipTypeId(dto.getMembershipTypeId());
		member.setStatus("ACTIVE");
		return member;
	}

	public TSNMember map(TSNMemberDTO dto) {
		TSNMember member = new TSNMember();

		return member;
	}

	public TSNMemberDTO map(TSNMember member) {
		TSNMemberDTO dto = new TSNMemberDTO();

		dto.setId(member.getId());
		dto.setContactNumber(member.getContactNumber());
		dto.setCreatedDateTime(member.getCreatedDateTime());
		dto.setCreatedUser(member.getCreatedUserName());
		dto.seteMail(member.geteMail());
		dto.setLastUpdatedDateTime(member.getLastUpdatedDateTime());
		dto.setLastUpdatedUser(member.getLastUpdatedUserName());
		dto.setMembershipType(member.getMembershipType());
		dto.setName(member.getName());
		dto.setTsnJoinedDate(member.getTsnJoinedDate());

		return dto;
	}

	public List<TSNMemberDTO> map(List<TSNMember> members) {
		List<TSNMemberDTO> dtos = new ArrayList<>();
		members.stream().forEach(m -> {
			dtos.add(map(m));
		});
		return dtos;
	}
}
