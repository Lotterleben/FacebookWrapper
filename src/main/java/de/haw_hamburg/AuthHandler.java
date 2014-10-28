package de.haw_hamburg;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.omg.CORBA.portable.ResponseHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Properties;

/**
 * Created by lotte on 28.10.14.
 */
public class AuthHandler {

    private  PropertyHandler propertyHandler;
    private String appID;
    private String appSecret;
    private String oauthAccessToken;
    private static String userAccessToken;
    private int myPort = 8200;

    public AuthHandler() {
        propertyHandler = PropertyHandler.getInstance();

        appID = propertyHandler.getProperty("appID");
        appSecret = propertyHandler.getProperty("appSecret");
        oauthAccessToken = propertyHandler.getProperty("oauthAccessToken");
    }

    public void  startServer() {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(myPort), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/test", new ResponseHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public void login() {
        startServer();
        String redirectUri = String.format("http://localhost:%d/test", myPort);
        String requestStr = String.format("https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s", appID, redirectUri);
        System.out.println("Please copy & paste the following into your browser and grant the app access");
        System.out.println(requestStr);
    }

    class ResponseHandler implements HttpHandler {
        public void handle(HttpExchange he) throws IOException {
            userAccessToken = he.getRequestURI().getQuery();

            System.out.println("I can haz new access token:");
            System.out.println(userAccessToken);

            propertyHandler.setProperty("userAccessToken", userAccessToken);
        }
    }
}
