package org.tsn.app.admin.master;

import org.springframework.stereotype.Component;
import org.tsn.app.admin.ApplicationConstants;

@Component
public class MasterMapper {

	public ProgramCategory map(String name) {
		ProgramCategory pc = new ProgramCategory();
		pc.setCategoryName(name);
		pc.setLastUpdatedUserName(ApplicationConstants.APPLICATION_ID);
		pc.setCreatedUserName(ApplicationConstants.APPLICATION_ID);
		return pc;
	}

}
