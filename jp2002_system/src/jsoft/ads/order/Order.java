package jsoft.ads.order;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Order extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addOrder(OrderObject item);
	public boolean editOrder(OrderObject item);
	public boolean delOrder(OrderObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getOrder(int id);
	public ResultSet getOrders(OrderObject similar, int at, byte total);

}
