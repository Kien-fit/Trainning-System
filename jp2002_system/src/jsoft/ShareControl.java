package jsoft;

public interface ShareControl {

	//Các chức năng điều khiển chia sẻ bộ quản lý kết nối giữa các Basic
	public ConnectionPool getCP();
	public void releaseConnection();
}
