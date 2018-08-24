package VC.server.bz.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import VC.common.SocketConstant;
import VC.common.Message;
import VC.server.dao.DAO;
import VC.common.Book;

public class ServerSrvImpl {

	private ServerSocket serversocket = null;
	private static final int SERVER_PORT = SocketConstant.SERVER_PORT;
	
	public ServerSrvImpl() throws IOException {
		
		try {
			this.setServersocket(new ServerSocket(SERVER_PORT));
			System.out.println("Server is on the PORT " + SERVER_PORT + " listening");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void run() throws IOException, ClassNotFoundException {
		boolean isclosed = false;
		
		while(!isclosed) {
			Socket rsvsocket = serversocket.accept();
			
			Message rcvmsg = new Message();
			ObjectInputStream ois = new ObjectInputStream(rsvsocket.getInputStream());
			rcvmsg = (Message) ois.readObject();
			
			String bookname = rcvmsg.getBookname();
			
			Book book = new Book();
			DAO bookdao = new DAO();
			book = bookdao.BookQuery(bookname);
			System.out.println("the received answer is " + book.toString() + ". is that right?");
			
			isclosed = true;
		}
	}
	
	public ServerSocket getServersocket() {
		return serversocket;
	}

	public void setServersocket(ServerSocket serversocket) {
		this.serversocket = serversocket;
	}
}
