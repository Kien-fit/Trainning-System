package jsoft.ads.log;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class LogControl {

	private LogModel log;

	public LogControl(ConnectionPool cp) {
		this.log = new LogModel(cp);
	}

	protected void finalize() throws Throwable {
		this.log = null;
		super.finalize();
	}

	public void relaeseConnection() {
		this.log.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.log.getCP();
	}
	
	// ------------------------------------------------
		public boolean addLog(LogObject item) {
			return this.log.addLog(item);
		}

		public boolean editLog(LogObject item) {
			return this.log.editLog(item);
		}

		public boolean delLog(LogObject item) {
			return this.log.delLog(item);
		}

		// ------------------------------------------------
		public LogObject getLogObject(short id) {
			return this.log.getLogObject(id);
		}

		public String getLogObject(LogObject similar, short page, byte total) {

			ArrayList<LogObject> items = new ArrayList<LogObject>();

			return LogLibrary.viewLogs(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
