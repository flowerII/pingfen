package cn.qianshu.pingfen.entity;

import java.util.Date;

public class Activity {

    private Integer id;
	
	private String name;
	
	private String holdaddress;
	
	private boolean avg;
	
	private boolean koufen;
	
	private int active;
	
	private Date holdtime;

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", holdaddress=" + holdaddress + ", avg=" + avg + ", koufen="
				+ koufen + ", active=" + active + ", holdtime=" + holdtime + "]";
	}

	public Activity(String name, String holdaddress, boolean avg, boolean koufen, Date holdtime) {
		super();
		this.name = name;
		this.holdaddress = holdaddress;
		this.avg = avg;
		this.koufen = koufen;
		this.holdtime = holdtime;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getHoldtime() {
		return holdtime;
	}

	public void setHoldtime(Date holdtime) {
		this.holdtime = holdtime;
	}

	public String getHoldaddress() {
		return holdaddress;
	}

	public void setHoldaddress(String holdaddress) {
		this.holdaddress = holdaddress;
	}

	public boolean isAvg() {
		return avg;
	}

	public void setAvg(boolean avg) {
		this.avg = avg;
	}

	public boolean isKoufen() {
		return koufen;
	}

	public void setKoufen(boolean koufen) {
		this.koufen = koufen;
	}
}
