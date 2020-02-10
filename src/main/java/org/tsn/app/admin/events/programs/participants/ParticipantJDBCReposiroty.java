package org.tsn.app.admin.events.programs.participants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.tsn.app.admin.base.BaseJDBCRepository;

@Repository
public class ParticipantJDBCReposiroty extends BaseJDBCRepository implements ParticipantRepository {

	private static final String INSERT_PARTICIPANT = "insert into tsn_prg_prtp(prg_id, prtp_name, prtp_cnct_nbr, prtp_cnct_email, prtp_alt_cnct_nbr, prtp_age, prtp_gender, prtp_par_name)"
			+ "values (:programId,:name,:contactNumber,:email,:alterNativeContact,:age,:gender,:parentName)";

	@Override
	public void createProgramParticipant(List<Participant> dto) {
		List<MapSqlParameterSource> participantList = new ArrayList<MapSqlParameterSource>();

		dto.stream().forEach(dt -> {
			participantList.add(buildParmeter(dt));
		});

		participantList.stream().forEach(participant -> {
			KeyHolder keyHolder =  new GeneratedKeyHolder();
			namedParameterJdbcTemplate.update(INSERT_PARTICIPANT, participant,keyHolder);
			System.out.println("created parpt id "+ keyHolder.getKey().longValue());
		});

	}

	private MapSqlParameterSource buildParmeter(Participant dt) {

		MapSqlParameterSource ms = new MapSqlParameterSource();

		ms.addValue("name", dt.getName());
		ms.addValue("contactNumber", dt.getContactNumber());
		ms.addValue("email", dt.getContactEmail());
		ms.addValue("alterNativeContact", dt.getAlternativeNumber());
		ms.addValue("age", dt.getAge());
		ms.addValue("gender", dt.getGender());
		ms.addValue("parentName", dt.getParentName());
		ms.addValue("programId", dt.getProgramId());

		return ms;
	}

}
