package cn.qianshu.pingfen.entity;

public class SUser {
	
	private int id;  
    private String name;  
    private String password;
    private String account;
    
	@Override
	public String toString() {
		return "SUser [id=" + id + ", name=" + name + ", password=" + password +", account="+ account+"]";
	}
	public SUser(int id, String name, String password,String account) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.account = account;
	}	
	public SUser(SUser sUser) {
		super();
		this.id = sUser.getId();
		this.name = sUser.getName();
		this.password = sUser.getPassword();
		this.account=sUser.getAccount();
	}	
	public SUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
    
}
