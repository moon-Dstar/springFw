package app.labs.ex00.prac;

public class Member {
	private String memberId;
	private String name;
	private int age;
	private String email;
	public String getMemberId() {
		return memberId;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
	

}
