package VC.server.bz;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.List;

import VC.common.Message;
import VC.common.SocketConstant;

public interface ServerSrv {
	
	ServerSocket serversocket = null;
	static final int SERVER_PORT = SocketConstant.SERVER_PORT;

	public void run();
	public void setServersocket(ServerSocket serversocket);
	public ServerSocket getServersocket();
}
