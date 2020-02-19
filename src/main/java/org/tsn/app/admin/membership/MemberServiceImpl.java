package org.tsn.app.admin.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Autowired
	private MemberRepository repository;

	@Override
	public List<TSNMemberDTO> findMembersBeLike(String searchTerm) {
		List<TSNMember> members = repository.findMembersLike(searchTerm);
		return mapper.map(members);
	}

	@Override
	public void createMember(CreateTSNMemberDTO memberDTO) {
		repository.createMember(mapper.map(memberDTO));
	}

	@Override
	public List<TSNMemberDTO> getAllMembersOfCategory(MembershipType category) {
		return mapper.map(repository.getAllMembersOfCategory(category.name()));
	}

	
	
	@Override
	public List<TSNMemberDTO> download(MembershipType category) {
		return null;
	}

	@Override
	public List<TSNMemberDTO> upload() {
		
		return null;
	}

}
