package cn.qianshu.pingfen.entity;

import java.util.List;

public class Act_add {

	private String name;
	
	private String holdaddress;
	
	private boolean avg;
	
	private boolean koufen;
	
	private int active;
	
	private String holdtime;
	
	private List<Integer> users;
	
	private List<Integer> teams;
	
	private List<Item> items;

	@Override
	public String toString() {
		return "Act_add [name=" + name + ", holdaddress=" + holdaddress + ", avg=" + avg + ", koufen=" + koufen
				+ ", active=" + active + ", holdtime=" + holdtime + ", users=" + users + ", teams=" + teams + ", items="
				+ items + "]";
	}

	public Act_add(String name, String holdaddress, boolean avg, boolean koufen, int active, String holdtime,
			List<Integer> users, List<Integer> teams, List<Item> items) {
		super();
		this.name = name;
		this.holdaddress = holdaddress;
		this.avg = avg;
		this.koufen = koufen;
		this.active = active;
		this.holdtime = holdtime;
		this.users = users;
		this.teams = teams;
		this.items = items;
	}

	public Act_add() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getHoldtime() {
		return holdtime;
	}

	public void setHoldtime(String holdtime) {
		this.holdtime = holdtime;
	}

	public List<Integer> getUsers() {
		return users;
	}

	public void setUsers(List<Integer> users) {
		this.users = users;
	}

	public List<Integer> getTeams() {
		return teams;
	}

	public void setTeams(List<Integer> teams) {
		this.teams = teams;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
