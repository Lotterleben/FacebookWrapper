package de.haw_hamburg;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FacebookWrapperMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        PropertyHandler.getInstance().setInitialProperties("xxx", "xxx", "xxx");

        HTTPHandler httpHandler = new HTTPHandler();
        httpHandler.get("http://graph.facebook.com/1509447019293978?fields=id,name");
        AuthHandler ah = new AuthHandler();
        ah.login();
	}

}
