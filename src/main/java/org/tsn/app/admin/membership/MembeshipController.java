package org.tsn.app.admin.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class MembeshipController {

	private static final String FIND_TSN_MEMBER = "/find-tsn-member/";
	private static final String  CREATE_TSN_MEMBER = "/create-tsn-member";
	
	@Autowired
	private MemberService service;
	
	@GetMapping(FIND_TSN_MEMBER)
	@ApiOperation(value="retruns member details that mathces with the given seach term")
	public List<TSNMemberDTO> findTSNMemberBySearchTerm(@RequestParam String searchTerm){
		return service.findMembersBeLike(searchTerm);
	}

	@PostMapping(CREATE_TSN_MEMBER)
	@ApiOperation(value="retruns member details that mathces with the given seach term")
	public  ResponseEntity<String> createTSNMember(@RequestBody CreateTSNMemberDTO newMemeberData){
		service.createMember(newMemeberData);
		return ResponseEntity.ok().body("SUCCESS");
	}
	
}
