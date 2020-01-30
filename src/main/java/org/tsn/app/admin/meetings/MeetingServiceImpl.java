package org.tsn.app.admin.meetings;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsn.app.admin.service.notification.Email;
import org.tsn.app.admin.service.notification.EmailHelper;
import org.tsn.app.admin.service.notification.EmailMapper;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private EmailMapper emailMapper;

	@Autowired
	private EmailHelper emailHelper;

	@Override
	public Boolean sendECMeetingEmail(MeetingDTO meetingDTO) {
		Email email = emailMapper.map(meetingDTO);
		populateRecepents("", email);
		emailHelper.sendEmail(email);
		return Boolean.TRUE;
	}

	private void populateRecepents(String meetingType, Email email) {

		// TODO Need to retrieve from database.
		email.setToEmailList(Arrays.asList("donepudi4u@gmail.com", "kajabhavani@gmail.com"));
		email.setFromName("TSN Secretary");
		email.setReplyEmail("secretary@telugusamiti.org");

	}

}
