package org.tsn.app.admin.service.notification;

import org.springframework.stereotype.Component;
import org.tsn.app.admin.meetings.MeetingDTO;

@Component
public class EmailMapper {

	public Email map(MeetingDTO meetingDTO) {
		Email email = new Email();
		email.setSubject(meetingDTO.getSubject());
		email.setBody(meetingDTO.getMeetingAgenda());

		return email;
	}

}
