package jsoft.ads.account;

import java.sql.*;
import jsoft.objects.*;
import jsoft.*;

public interface Account extends ShareControl {
	// Các chức năng cập nhật
	public boolean addAccount(AccountObject item);
	public boolean editAccount(AccountObject item);
	public boolean delAccount(AccountObject item);

	// Các chức năng lấy dữ liệu
	public ResultSet getAccount(short id);
	public ResultSet getAccounts(AccountObject similar, int at, byte total);
}
