package org.tsn.app.admin.membership;

import java.util.List;

public interface MemberService {

	List<TSNMemberDTO> findMembersBeLike(String searchTerm);

	void createMember(CreateTSNMemberDTO memberDTO);
	
}
