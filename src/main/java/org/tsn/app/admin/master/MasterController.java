package org.tsn.app.admin.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class MasterController {

	private static final String CREATE_PROG_CATEGORY = "";
	
	@Autowired
	private MasterService service;

	@PostMapping(CREATE_PROG_CATEGORY)
	@ApiOperation(value="creates program category")
	public ResponseEntity<String> createProgramCategory(String categoryName){
		service.createProgramCategory(categoryName);
		return ResponseEntity.ok().body("Created Successfully!!");
	}
	
}
