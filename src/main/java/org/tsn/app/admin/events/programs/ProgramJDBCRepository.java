package org.tsn.app.admin.events.programs;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;

@Repository
public class ProgramJDBCRepository extends BaseJDBCRepository implements ProgramRepository {

	private static final String CREATE_PROGRAM = " insert into tsn_evnt_prg (evnt_id, prg_name, prg_ctgy_id, prg_dur_in_min, is_grp_prog, grp_name, prg_prim_cnct_name, prg_prim_cnct_num, prg_evnt_ordr, crtn_dt, crtn_by, last_uptd_by, last_uptd_dt) "
			+ " values (:eventId,:programName,:status,:categoryId,:duration,:isGroupProgram,:groupName,:contactName,:contactNumber,:programOrder,now(),:createdUser,:lastUpdatedUser,now())";

	@Override
	public void createProgram(Program program) {
		MapSqlParameterSource parameterSource = buildProgramParameters(program);

		int programId = namedParameterJdbcTemplate.update(CREATE_PROGRAM, parameterSource);
		System.out.println("program Id created : " + programId);
	}

	private MapSqlParameterSource buildProgramParameters(Program program) {
		MapSqlParameterSource pararmSource = new MapSqlParameterSource();
		pararmSource.addValue("eventId", program.getEventId());
		pararmSource.addValue("programName", program.getProgramName());
		pararmSource.addValue("status", program.getStatus());
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

	@Override
	public List<Program> getAllProgramsByEventId(Long eventId) {
		return null;
	}

}
