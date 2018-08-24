package VC.common;

public class Message implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5535907556455611442L;
	private String bookname;
	private Book book;

	public Message(){
		
	}
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
