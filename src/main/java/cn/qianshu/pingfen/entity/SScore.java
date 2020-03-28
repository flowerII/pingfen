package cn.qianshu.pingfen.entity;

public class SScore {

	private int id;
	private int activity_id;
    private String activity_name;
    private int user_id;
    private String user_name;
    private int team_id;
    private String team_name;
    private int item_id;
    private String item_name;
	private int score;
	
	@Override
	public String toString() {
		return "SScore [id=" + id + ", activity_id=" + activity_id + ", activity_name=" + activity_name + ", user_id="
				+ user_id + ", user_name=" + user_name + ", team_id=" + team_id + ", team_name=" + team_name
				+ ", item_id=" + item_id + ", item_name=" + item_name + ", score=" + score + "]";
	}
	public SScore(int id, int activity_id, String activity_name, int user_id, String user_name, int team_id,
			String team_name, int item_id, String item_name, int score) {
		super();
		this.id = id;
		this.activity_id = activity_id;
		this.activity_name = activity_name;
		this.user_id = user_id;
		this.user_name = user_name;
		this.team_id = team_id;
		this.team_name = team_name;
		this.item_id = item_id;
		this.item_name = item_name;
		this.score = score;
	}
	public SScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SScore(int activity_id2, String activity_name2, int user_id2, String user_name2, int team_id2,
			String team_name2, int item_id, String item_name, Integer score) {
		super();
		this.activity_id = activity_id2;
		this.activity_name = activity_name2;
		this.user_id = user_id2;
		this.user_name = user_name2;
		this.team_id = team_id2;
		this.team_name = team_name2;
		this.item_id = item_id;
		this.item_name = item_name;
		this.score = score;
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
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}	
	
}
