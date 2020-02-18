package org.tsn.app.admin.membership;

import java.time.LocalDateTime;

import org.tsn.app.admin.base.BaseEntity;

public class TSNMember extends BaseEntity {

	private String name;
	private String eMail;
	private String contactNumber;
	private String membershipType;
	private Integer memberShipTypeId;
	private LocalDateTime tsnJoinedDate;
	private String status;

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

	public Integer getMemberShipTypeId() {
		return memberShipTypeId;
	}

	public void setMemberShipTypeId(Integer memberShipTypeId) {
		this.memberShipTypeId = memberShipTypeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
