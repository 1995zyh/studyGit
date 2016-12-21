package com.yc.bank.entity;

public class User {
	private Integer id;
	private String name;  //用户姓名
	private String password;  //用户密码
	private String idCardNo;  //身份证号码
	private String sex;  //性别
	private String birthday;  //生日
	private String phone;  //联系电话
	private String hasCard;  //是否持卡
	private String homeAddress;  //家庭地址
	private String mailbox; //邮箱
	private String company;  //工作单位
	private Double salary;  //月收入
	private String workingAddress;  //工作地址
	private String workingPhone;  //工作电话
	private String post;   //职位
	private String remark;
	
	public User() {
	}
	public User(Integer id, String name, String password, String idCardNo, String sex, String birthday, String phone,
			String hasCard, String homeAddress, String mailbox, String company, Double salary, String workingAddress,
			String workingPhone, String post, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.idCardNo = idCardNo;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.hasCard = hasCard;
		this.homeAddress = homeAddress;
		this.mailbox = mailbox;
		this.company = company;
		this.salary = salary;
		this.workingAddress = workingAddress;
		this.workingPhone = workingPhone;
		this.post = post;
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHasCard() {
		return hasCard;
	}
	public void setHasCard(String hasCard) {
		this.hasCard = hasCard;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getWorkingAddress() {
		return workingAddress;
	}
	public void setWorkingAddress(String workingAddress) {
		this.workingAddress = workingAddress;
	}
	public String getWorkingPhone() {
		return workingPhone;
	}
	public void setWorkingPhone(String workingPhone) {
		this.workingPhone = workingPhone;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", idCardNo=" + idCardNo + ", sex="
				+ sex + ", birthday=" + birthday + ", phone=" + phone + ", hasCard=" + hasCard + ", homeAddress="
				+ homeAddress + ", mailbox=" + mailbox + ", company=" + company + ", salary=" + salary
				+ ", workingAddress=" + workingAddress + ", workingPhone=" + workingPhone + ", post=" + post
				+ ", remark=" + remark + "]";
	} 
	
}
