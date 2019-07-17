package com.email;

import javax.mail.MessagingException;

public class JavaMain {
	
	public static void main(String[] args) throws MessagingException {
		
		JavaMailUtil.sendMail("recipient");
	}

}
