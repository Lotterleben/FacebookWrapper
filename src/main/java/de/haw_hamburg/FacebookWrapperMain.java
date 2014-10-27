package de.haw_hamburg;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FacebookWrapperMain {

    /*
    * Create properties file with login credentials so they don't accidentally get pushed somewhere. Only needs to be
    * called once.
    * */
    private static void setProperties(String appID, String appSecret, String oauthAccessToken){
        try {
            FileWriter writer = new FileWriter( "properties.txt" );
            Properties props = new Properties();
            props.setProperty("appID", appID);
            props.setProperty("appSecret", appSecret);
            props.setProperty("oauthAccessToken", oauthAccessToken);
            props.store(writer, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        HTTPHandler httpHandler = new HTTPHandler();
        httpHandler.get("http://graph.facebook.com/1509447019293978?fields=id,name");
	}

}
