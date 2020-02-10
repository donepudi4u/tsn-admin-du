package org.tsn.app.admin.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterRepository repository;
	
	@Autowired
	private MasterMapper mapper;
	
	@Override
	public void createProgramCategory(String categoryName) {

		repository.createProgramCategory(mapper.map(categoryName));
	}

}
