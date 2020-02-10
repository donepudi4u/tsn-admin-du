package org.tsn.app.admin.master;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;

@Repository
public class MasterJDBCRepository extends BaseJDBCRepository implements MasterRepository {

	private static final String CREATE_PRODUCT_CATEGORY = " insert into tsn_evnt_prg_ctg (ctg_name, crtn_dt, crtn_by, last_uptd_by, last_uptd_dt) "
			+ " values (:categoryName,now(),:createdUser,:lastUpdateUser,now()) ";

	@Override
	public void createProgramCategory(ProgramCategory category) {
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		paramSource.addValue("categoryName", category.getCategoryName());
		paramSource.addValue("lastUpdateUser", category.getLastUpdatedUserName());
		paramSource.addValue("createdUser", category.getCreatedUserName());

		int categoryId = namedParameterJdbcTemplate.update(CREATE_PRODUCT_CATEGORY, paramSource);
		System.out.println("Category Created with Id : " + categoryId);

	}

}
