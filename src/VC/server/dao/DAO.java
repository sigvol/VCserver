package VC.server.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import VC.common.Book;

public class DAO {
	private static final String HXTT_ACCESS_JDBC_DRIVER = "com.hxtt.sql.access.AccessDriver";
	private static final String ACCESS_DRIVER = HXTT_ACCESS_JDBC_DRIVER;
	private static String url;
	static String user = "";
	static String password = null;

	static {
		String dbpath = new File("").getAbsolutePath().replace('\\', '/') + "/Database2.accdb";
		// url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb,
		// *.accdb)};DBQ="+dbpath;
		// url = "jdbc:ucanaccess://" + dbpath;
		url = "jdbc:access:/" + dbpath;
		// System.out.println(url);
	}

	public DAO() {

	}

	public Book BookQuery(String bookname) {
		Connection ct = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;
		String BookN = null;
		String BookP = null;
		String BookA = null;
		Book book = new Book();
		try {
			Class.forName(ACCESS_DRIVER);
			ct = DriverManager.getConnection(url, user, password);
			sql = "select * from library where bookname = ?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, bookname);
			rs = ps.executeQuery();

			while (rs.next()) {
				BookN = rs.getString("bookname");
				BookP = rs.getString("bookpublisher");
				BookA = rs.getString("bookauthor");

				book.setBookName(BookN);
				book.setBookAuthor(BookA);
				book.setBookPublisher(BookP);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
}
