package org.openserp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.openserp.enums.LoginStatus;
import org.openserp.enums.UserType;

@Entity
@Table(name = "CTX_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	@Column(name = "VERSION")
	private Integer version;

	@Column(name = "USERNAME")
	@Id
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USERTYPE")
	private String userType;

	@Column(name = "ENABLED")
	private String enabled;

	@Column(name = "FAILED_COUNT")
	private Integer failedCount;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	private List<UserRole> roles;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return UserType.getEnum(this.userType);
	}

	public void setUserType(UserType userType) {
		this.userType = userType.getValue();
	}

	public LoginStatus getEnabled() {
		return LoginStatus.getEnum(this.enabled);
	}

	public void setEnabled(LoginStatus loginStatus) {
		this.enabled = loginStatus.getValue();
	}

	public Integer getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(Integer failedCount) {
		this.failedCount = failedCount;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [version=" + version + ", username=" + username
				+ ", password=" + password + ", enabled=" + enabled
				+ ", failedCount=" + failedCount + ", roles=" + roles + "]";
	}

}
