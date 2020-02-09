package org.tsn.app.admin.master;

import org.springframework.stereotype.Component;
import org.tsn.app.admin.ApplicationConstants;

@Component
public class MasterMapper {

	public ProgramCategory map(ProgramCategoryDTO dto) {
		ProgramCategory pc = new ProgramCategory();
		pc.setCategoryName(dto.getCategoryName());
		pc.setLastUpdatedUserName(ApplicationConstants.APPLICATION_ID);
		pc.setCreatedUserName(ApplicationConstants.APPLICATION_ID);
		return pc;
	}

}
