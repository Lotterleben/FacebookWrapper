package de.haw_hamburg;


public class FacebookWrapperMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        // chaotic stuff for testing only
        PropertyHandler.getInstance().setInitialProperties("1509447019293978", "d37ba2a48cd701f28e90679face51ac5", "1509447019293978|jSJ2DBNsOTgWwzzWK0QAt1bUGGQ");

        RequestHandler requestHandler = RequestHandler.getInstance();
        //requestHandler.get("http://graph.facebook.com/1509447019293978?fields=id,name");
        AuthHandler ah = new AuthHandler();
        ah.login();
	}

}
