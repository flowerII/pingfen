package cn.qianshu.pingfen.entity;

public class SItem {

	private int id;
	private int activity_id;
    private String name;
	private int scale1;
	
	@Override
	public String toString() {
		return "AItem [id=" + id + ", activity_id=" + activity_id + ", name=" + name + ", scale1=" + scale1 + "]";
	}
	public SItem(int id, int activity_id, String name, int scale1) {
		super();
		this.id = id;
		this.activity_id = activity_id;
		this.name = name;
		this.scale1 = scale1;
	}
	public SItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScale1() {
		return scale1;
	}
	public void setScale1(int scale1) {
		this.scale1 = scale1;
	}

}
