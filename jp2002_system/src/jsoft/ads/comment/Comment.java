package jsoft.ads.comment;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Comment extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addComment(CommentObject item);
	public boolean editComment(CommentObject item);
	public boolean delComment(CommentObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getComment(int id);
	public ResultSet getComments(CommentObject similar, int at, byte total);

}
