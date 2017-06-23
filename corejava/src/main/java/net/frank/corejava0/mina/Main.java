package net.frank.corejava0.mina;

import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class Main {
	public static void main(String[] args) throws Exception {
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		IoConnector connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(5 * 1000L);
		
		//ClientToProxyIoHandler handler = new ClientToProxyIoHandler( connector,
		//		new InetSocketAddress("localhost", Integer.parseInt( "28080") ) );
		
		acceptor.bind(new InetSocketAddress(Integer.parseInt("18080")));

	}

}
