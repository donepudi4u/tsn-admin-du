package org.tsn.app.admin.membership;

import java.time.LocalDateTime;

import org.tsn.app.admin.base.BaseDTO;

public class TSNMemberDTO extends BaseDTO{

	private String name;
	private String eMail;
	private String contactNumber;
	private String membershipType;
	private LocalDateTime tsnJoinedDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public LocalDateTime getTsnJoinedDate() {
		return tsnJoinedDate;
	}

	public void setTsnJoinedDate(LocalDateTime tsnJoinedDate) {
		this.tsnJoinedDate = tsnJoinedDate;
	}

}
