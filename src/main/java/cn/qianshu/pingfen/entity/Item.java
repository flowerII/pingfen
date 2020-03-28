package cn.qianshu.pingfen.entity;

public class Item {

    private String name;
	
	private int scale1;

	@Override
	public String toString() {
		return "Item [name=" + name + ", scale1=" + scale1 + "]";
	}

	public Item(String name, int scale1) {
		super();
		this.name = name;
		this.scale1 = scale1;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getScale1() {
		return scale1;
	}

	public void setScale1(int scale1) {
		this.scale1 = scale1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
