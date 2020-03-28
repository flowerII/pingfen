package cn.qianshu.pingfen.entity;

public class Koufen {

	private int id;
	private int activity_id;
    private String activity_name;
    private int team_id;
    private String team_name;
	private int koufen;
	
	@Override
	public String toString() {
		return "Koufen [id=" + id + ", activity_id=" + activity_id + ", activity_name=" + activity_name + ", team_id="
				+ team_id + ", team_name=" + team_name + ", koufen=" + koufen + "]";
	}
	public Koufen(int id, int activity_id, String activity_name, int team_id, String team_name, int koufen) {
		super();
		this.id = id;
		this.activity_id = activity_id;
		this.activity_name = activity_name;
		this.team_id = team_id;
		this.team_name = team_name;
		this.koufen = koufen;
	}
	public Koufen() {
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
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public int getKoufen() {
		return koufen;
	}
	public void setKoufen(int koufen) {
		this.koufen = koufen;
	}
	
}
