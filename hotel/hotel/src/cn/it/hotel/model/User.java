package cn.it.hotel.model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String ulogin;
	private String uname;
	private String upassword;
	private Integer usex;
	private String uphone;
	private Integer ucategory;
	private Integer ustate;


	@Override
	public String toString() {
		return "User [uid=" + uid + ", ulogin=" + ulogin + ", uname=" + uname
				+ ", upassword=" + upassword + ", usex=" + usex + ", uphone="
				+ uphone + ", ucategory=" + ucategory + ", ustate=" + ustate
				+ "]";
	}

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String ulogin, String uname, String upassword, Integer usex,
			String uphone, Integer ucategory, Integer ustate) {
		this.ulogin = ulogin;
		this.uname = uname;
		this.upassword = upassword;
		this.usex = usex;
		this.uphone = uphone;
		this.ucategory = ucategory;
		this.ustate = ustate;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUlogin() {
		return this.ulogin;
	}

	public void setUlogin(String ulogin) {
		this.ulogin = ulogin;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return this.upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public Integer getUsex() {
		return this.usex;
	}

	public void setUsex(Integer usex) {
		this.usex = usex;
	}

	public String getUphone() {
		return this.uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public Integer getUcategory() {
		return this.ucategory;
	}

	public void setUcategory(Integer ucategory) {
		this.ucategory = ucategory;
	}

	public Integer getUstate() {
		return this.ustate;
	}

	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}

}