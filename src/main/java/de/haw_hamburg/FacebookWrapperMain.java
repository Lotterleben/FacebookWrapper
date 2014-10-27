package de.haw_hamburg;


public class FacebookWrapperMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Ohai!");
        HTTPHandler httpHandler = new HTTPHandler();
        httpHandler.get();
	}

}
