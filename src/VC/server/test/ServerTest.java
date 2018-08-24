package VC.server.test;

import VC.server.*;
import VC.server.bz.Impl.ServerSrvImpl;

import java.io.IOException;

import VC.common.*;
public class ServerTest {
	
	public static void main(String[] args) {
		
		try {
			ServerSrvImpl test = new ServerSrvImpl();
			try {
				test.run();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
