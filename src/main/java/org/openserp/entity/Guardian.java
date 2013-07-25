package org.openserp.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "CTX_GUARDIAN")
public class Guardian implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RECID")
	private Integer recid;

	
	@Version
	@Column(name = "VERSION")
	private Integer version;

	
	@Column(name = "LAST_NAME")
	private String lastName;

	
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "NAME_SUFFIX")
	private String nameSuffix;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "BDATE")
	private Date bdate;

	
	@Column(name = "ADDRESS1")
	private String address1;

	
	@Column(name = "ADDRESS2")
	private String address2;
	
	
	@Column(name = "ADDRESS3")
	private String address3;
	
	
	@Column(name = "CONTACT_NO")
	private String contactNo;

	
	public Integer getRecid() {
		return this.recid;
	}

	public void setRecid(Integer recid) {
		this.recid = recid;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getNameSuffix() {
		return this.nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public Date getBdate() {
		return this.bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getFirstName())
				.append(this.getLastName()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guardian other = (Guardian) obj;
		return new EqualsBuilder()
				.append(this.getFirstName(), other.getFirstName())
				.append(this.getLastName(), other.getLastName())
				.append(this.getBdate(), other.getBdate())
				.isEquals();
	}

	
}
