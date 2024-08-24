package jsoft.ads.comment;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class CommentControl {

	private CommentModel cm;

	public CommentControl(ConnectionPool cp) {
		this.cm = new CommentModel(cp);
	}

	protected void finalize() throws Throwable {
		this.cm = null;
		super.finalize();
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}

	// ------------------------------------------------
	public boolean addComment(CommentObject item) {
		return this.cm.addComment(item);
	}

	public boolean editComment(CommentObject item) {
		return this.cm.editComment(item);
	}

	public boolean delComment(CommentObject item) {
		return this.cm.delComment(item);
	}

	// ------------------------------------------------
	public CommentObject getCommentObject(int id) {
		return this.cm.getCommentObject(id);
	}

	public String viewComments(CommentObject similar, short page, byte total) {

		ArrayList<CommentObject> items = new ArrayList<CommentObject>();

		return CommentLibrary.viewComments(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
