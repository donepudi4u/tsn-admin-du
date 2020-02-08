package org.tsn.app.admin.events.programs;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;

@Repository
public class ProgramJDBCRepository extends BaseJDBCRepository implements ProgramRepository {

	private static final String CREATE_PROGRAM = null;

	@Override
	public void createProgram(Program program) {
		MapSqlParameterSource parameterSource  = buildProgramParameters(program);
		
		int programId = namedParameterJdbcTemplate.update(CREATE_PROGRAM, parameterSource);
		System.out.println("program Id created : " + programId);
	}

	private MapSqlParameterSource buildProgramParameters(Program program) {
		MapSqlParameterSource pararmSource = new MapSqlParameterSource();
		pararmSource.addValue("eventId", program.getEventId());
		pararmSource.addValue("programName", program.getProgramName());
		pararmSource.addValue("categoryId", program.getProgramCategoryId());
		pararmSource.addValue("duration", program.getProgramDurationInMinutes());
		pararmSource.addValue("isGroupProgram", program.getIsGroupProgram());
		pararmSource.addValue("groupName", program.getGroupName());
		pararmSource.addValue("contactName", program.getPrimaryContactName());
		pararmSource.addValue("contactNumber", program.getPrimaryContactNumber());
		pararmSource.addValue("programOrder", program.getProgramOrder());
		pararmSource.addValue("lastUpdatedUser", program.getLastUpdatedUserName());
		pararmSource.addValue("createdUser", program.getCreatedUserName());
		
		return pararmSource;
	}

}
