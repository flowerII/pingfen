package cn.qianshu.pingfen.entity;

public class Rank {

	private int id;
	private int activity_id;
    private String activity_name;
    private int team_id;
    private String team_name;
    private int max_;
    private int min_;
    private int avg_;
	private int koufen;
	private int last_;
	
	@Override
	public String toString() {
		return "Rank [id=" + id + ", activity_id=" + activity_id + ", activity_name=" + activity_name + ", team_id="
				+ team_id + ", team_name=" + team_name + ", max_=" + max_ + ", min_=" + min_ + ", avg_=" + avg_
				+ ", koufen=" + koufen + ", last_=" + last_ + "]";
	}
	public Rank(int id, int activity_id, String activity_name, int team_id, String team_name, int max_, int min_,
			int avg_, int koufen, int last_) {
		super();
		this.id = id;
		this.activity_id = activity_id;
		this.activity_name = activity_name;
		this.team_id = team_id;
		this.team_name = team_name;
		this.max_ = max_;
		this.min_ = min_;
		this.avg_ = avg_;
		this.koufen = koufen;
		this.last_ = last_;
	}
	public Rank() {
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
	public int getMax_() {
		return max_;
	}
	public void setMax_(int max_) {
		this.max_ = max_;
	}
	public int getMin_() {
		return min_;
	}
	public void setMin_(int min_) {
		this.min_ = min_;
	}
	public int getAvg_() {
		return avg_;
	}
	public void setAvg_(int avg_) {
		this.avg_ = avg_;
	}
	public int getKoufen() {
		return koufen;
	}
	public void setKoufen(int koufen) {
		this.koufen = koufen;
	}
	public int getLast_() {
		return last_;
	}
	public void setLast_(int last_) {
		this.last_ = last_;
	}
	
}
