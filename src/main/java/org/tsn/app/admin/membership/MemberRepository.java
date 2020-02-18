package org.tsn.app.admin.membership;

import java.util.List;

public interface MemberRepository {

	List<TSNMember> findMembersLike(String searchTerm);

	void createMember(TSNMember member);

}
