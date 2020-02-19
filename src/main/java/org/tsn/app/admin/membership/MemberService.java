package org.tsn.app.admin.membership;

import java.util.List;

public interface MemberService {

	List<TSNMemberDTO> findMembersBeLike(String searchTerm);

	void createMember(CreateTSNMemberDTO memberDTO);

	List<TSNMemberDTO> getAllMembersOfCategory(MembershipType category);

	List<TSNMemberDTO> download(MembershipType category);

	List<TSNMemberDTO> upload();
	
}
