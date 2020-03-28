package cn.qianshu.pingfen.entity;

public class SPermission {

	private int id;  
    private String permission;  
    private String url;  
    private String describe;
    
	@Override
	public String toString() {
		return "SPermission [id=" + id + ", permission=" + permission + ", url=" + url + ", describe=" + describe + "]";
	}
	public SPermission(int id, String permission, String url, String describe) {
		super();
		this.id = id;
		this.permission = permission;
		this.url = url;
		this.describe = describe;
	}
	public SPermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
    
}
