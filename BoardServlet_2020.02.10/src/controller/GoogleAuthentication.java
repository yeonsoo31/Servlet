package controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	PasswordAuthentication passAuth;
	
	public GoogleAuthentication() {
		passAuth = 
			new PasswordAuthentication("plusyys31","pzuxwdzfrefroscu");
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}
