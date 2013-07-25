package org.openserp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.openserp.enums.UserRoleEnum;

@Entity
@Table(name = "CTX_USER_ROLE")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	@Column(name = "VERSION")
	private Integer version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECID")
	private Integer recid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USERNAME", nullable = false)
	private User user;

	@Column(name = "ROLE")
	private String role;

	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRoleEnum getRole() {
		return UserRoleEnum.getEnum(this.role);
	}

	public void setRole(UserRoleEnum role) {
		this.role = role.getValue();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(user).append(role).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return new EqualsBuilder().append(this.getRole(), other.getRole())
				.append(this.getUser(), other.getUser()).isEquals();
	}

}
