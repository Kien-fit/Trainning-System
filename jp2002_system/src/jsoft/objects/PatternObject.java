package jsoft.objects;

public class PatternObject {
	
	private int pattern_id;
	private String pattern_title;//Tieu de mau thiet ke
	private String pattern_summary;//Ban mo ta tom tat mau
	private String pattern_detail;//Ban mo ta chi tiet mau
	private String pattern_image;//Hinh anh chuan
	private String pattern_image1;//Hinh anh phu 1
	private String pattern_image2;//Hinh anh phu 2
	private String pattern_image3;//Hinh anh phu 3
	private String pattern_created_date;//Ngay cap nhat mau
	private String pattern_last_modified;//Ngay chinh sua mau
	private String pattern_author_name;//Ten tac gia cap nhat mau
	private String pattern_author_name_comment;//Ten tac gia Binh luan mau
	private String pattern_comment;//Noi dung binh luan
	private String pattern_star;//Xep thu hang mau (1-5 sao)
	private String pattern_size;//Kich thuoc mau
	private short pattern_ps_id;//He san pham cua mau
	private short pattern_pg_id;//Nhom san pham cua mau
	private short pattern_pc_id;//Loai san pham cua mau
	private String pattern_code;//Ma cua mau
	private String pattern_user_view;//Nhung ai da xem mau
	private short pattern_visited;
	private byte pattern_approved;//Phe duyet
	private String pattern_approved_date;//Ngay duyet
	private String pattern_approved_name;//Nguoi duyet
	private short pattern_user_permis;//Quyen nguoi tao
	private boolean pattern_is_new_comment;//Co binh luan moi
	private String pattern_new_comment_date;//Ngay binh luan
	
	public int getPattern_id() {
		return pattern_id;
	}
	public void setPattern_id(int pattern_id) {
		this.pattern_id = pattern_id;
	}
	public String getPattern_title() {
		return pattern_title;
	}
	public void setPattern_title(String pattern_title) {
		this.pattern_title = pattern_title;
	}
	public String getPattern_summary() {
		return pattern_summary;
	}
	public void setPattern_summary(String pattern_summary) {
		this.pattern_summary = pattern_summary;
	}
	public String getPattern_detail() {
		return pattern_detail;
	}
	public void setPattern_detail(String pattern_detail) {
		this.pattern_detail = pattern_detail;
	}
	public String getPattern_image() {
		return pattern_image;
	}
	public void setPattern_image(String pattern_image) {
		this.pattern_image = pattern_image;
	}
	public String getPattern_image1() {
		return pattern_image1;
	}
	public void setPattern_image1(String pattern_image1) {
		this.pattern_image1 = pattern_image1;
	}
	public String getPattern_image2() {
		return pattern_image2;
	}
	public void setPattern_image2(String pattern_image2) {
		this.pattern_image2 = pattern_image2;
	}
	public String getPattern_image3() {
		return pattern_image3;
	}
	public void setPattern_image3(String pattern_image3) {
		this.pattern_image3 = pattern_image3;
	}
	public String getPattern_created_date() {
		return pattern_created_date;
	}
	public void setPattern_created_date(String pattern_created_date) {
		this.pattern_created_date = pattern_created_date;
	}
	public String getPattern_last_modified() {
		return pattern_last_modified;
	}
	public void setPattern_last_modified(String pattern_last_modified) {
		this.pattern_last_modified = pattern_last_modified;
	}
	public String getPattern_author_name() {
		return pattern_author_name;
	}
	public void setPattern_author_name(String pattern_author_name) {
		this.pattern_author_name = pattern_author_name;
	}
	public String getPattern_author_name_comment() {
		return pattern_author_name_comment;
	}
	public void setPattern_author_name_comment(String pattern_author_name_comment) {
		this.pattern_author_name_comment = pattern_author_name_comment;
	}
	public String getPattern_comment() {
		return pattern_comment;
	}
	public void setPattern_comment(String pattern_comment) {
		this.pattern_comment = pattern_comment;
	}
	public String getPattern_star() {
		return pattern_star;
	}
	public void setPattern_star(String pattern_star) {
		this.pattern_star = pattern_star;
	}
	public String getPattern_size() {
		return pattern_size;
	}
	public void setPattern_size(String pattern_size) {
		this.pattern_size = pattern_size;
	}
	public short getPattern_ps_id() {
		return pattern_ps_id;
	}
	public void setPattern_ps_id(short pattern_ps_id) {
		this.pattern_ps_id = pattern_ps_id;
	}
	public short getPattern_pg_id() {
		return pattern_pg_id;
	}
	public void setPattern_pg_id(short pattern_pg_id) {
		this.pattern_pg_id = pattern_pg_id;
	}
	public short getPattern_pc_id() {
		return pattern_pc_id;
	}
	public void setPattern_pc_id(short pattern_pc_id) {
		this.pattern_pc_id = pattern_pc_id;
	}
	public String getPattern_code() {
		return pattern_code;
	}
	public void setPattern_code(String pattern_code) {
		this.pattern_code = pattern_code;
	}
	public String getPattern_user_view() {
		return pattern_user_view;
	}
	public void setPattern_user_view(String pattern_user_view) {
		this.pattern_user_view = pattern_user_view;
	}
	public short getPattern_visited() {
		return pattern_visited;
	}
	public void setPattern_visited(short pattern_visited) {
		this.pattern_visited = pattern_visited;
	}
	public byte getPattern_approved() {
		return pattern_approved;
	}
	public void setPattern_approved(byte pattern_approved) {
		this.pattern_approved = pattern_approved;
	}
	public String getPattern_approved_date() {
		return pattern_approved_date;
	}
	public void setPattern_approved_date(String pattern_approved_date) {
		this.pattern_approved_date = pattern_approved_date;
	}
	public String getPattern_approved_name() {
		return pattern_approved_name;
	}
	public void setPattern_approved_name(String pattern_approved_name) {
		this.pattern_approved_name = pattern_approved_name;
	}
	public short getPattern_user_permis() {
		return pattern_user_permis;
	}
	public void setPattern_user_permis(short pattern_user_permis) {
		this.pattern_user_permis = pattern_user_permis;
	}
	public boolean isPattern_is_new_comment() {
		return pattern_is_new_comment;
	}
	public void setPattern_is_new_comment(boolean pattern_is_new_comment) {
		this.pattern_is_new_comment = pattern_is_new_comment;
	}
	public String getPattern_new_comment_date() {
		return pattern_new_comment_date;
	}
	public void setPattern_new_comment_date(String pattern_new_comment_date) {
		this.pattern_new_comment_date = pattern_new_comment_date;
	}
	

}
