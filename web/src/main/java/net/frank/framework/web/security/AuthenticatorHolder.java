package net.frank.framework.web.security;

public class AuthenticatorHolder {
	static ThreadLocal<ClientSession> clientSessionLocal = new ThreadLocal<ClientSession>();
	public static void setClientSession(ClientSession clientSession) {
		clientSessionLocal.set(clientSession);
	}

	public static ClientSession getClientSession() {
		return clientSessionLocal.get();
	}
}
