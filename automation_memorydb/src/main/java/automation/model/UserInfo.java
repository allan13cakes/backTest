package automation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfo {
	@Id
	@GeneratedValue
	private Long id;
	private String testAccount;
	private String password;
	private String email;
	private String accountName;
	private String name;
	private String credid;
	private String phone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTestAccount() {
		return testAccount;
	}
	public void setTestAccount(String testAccount) {
		this.testAccount = testAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCredid() {
		return credid;
	}
	public void setCredid(String credid) {
		this.credid = credid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", testAccount=" + testAccount + ", password=" + password + ", email=" + email
				+ ", accountName=" + accountName + ", name=" + name + ", credid=" + credid + ", phone=" + phone + "]";
	}
	
}
