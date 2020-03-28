package cn.qianshu.pingfen.entity;

public class STotal {

	private int id;
	private int activity_id;
    private String activity_name;
    private int user_id;
    private String user_name;
    private int team_id;
    private String team_name;
	private int total;
	
	@Override
	public String toString() {
		return "STotal [id=" + id + ", activity_id=" + activity_id + ", activity_name=" + activity_name + ", user_id="
				+ user_id + ", user_name=" + user_name + ", team_id=" + team_id + ", team_name=" + team_name
				+ ", total=" + total + "]";
	}
	public STotal(int id, int activity_id, String activity_name, int user_id, String user_name, int team_id,
			String team_name, int total) {
		super();
		this.id = id;
		this.activity_id = activity_id;
		this.activity_name = activity_name;
		this.user_id = user_id;
		this.user_name = user_name;
		this.team_id = team_id;
		this.team_name = team_name;
		this.total = total;
	}
	public STotal() {
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
