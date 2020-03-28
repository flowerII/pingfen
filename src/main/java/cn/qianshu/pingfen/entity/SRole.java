package cn.qianshu.pingfen.entity;

public class SRole {
	
	private int id;  
    private String role;  
    private String describe;
    
	@Override
	public String toString() {
		return "SRole [id=" + id + ", role=" + role + ", describe=" + describe + "]";
	}
	public SRole(int id, String role, String describe) {
		super();
		this.id = id;
		this.role = role;
		this.describe = describe;
	}
	public SRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
