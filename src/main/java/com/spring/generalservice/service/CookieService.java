package com.spring.generalservice.service;

import spark.Request;
import spark.Response;

import javax.servlet.http.Cookie;
import java.util.Map;

public class CookieService {

    public static String displayCookies(Request request, Response response) throws Exception {
        String newLine = "<br/>";
        String message = "<b> Display Cookies </b>" + newLine;
        for(String cookieName : request.cookies().keySet() ) {
            String cookieValue = request.cookies().get(cookieName);
            message += " <br> <b> " + cookieName + "</b>" + " -> " + cookieValue;
        }
        return message;
    }

    public static String storeCookies(Request request, Response response) throws Exception {
        response.cookie("Heroku-Username", "Anonymous-StoreCookie", 10000, true );
        response.cookie("Heroku-SessionId", "SessionId-StoreCookie", 10000, true );
        return "Store Cookies";
    }

    public static String storeCookiesNone(Request request, Response response) {
        response.header("Set-Cookie","Heroku-Username=Anonymous-StoreCookie-None; Secure; SameSite=None");
        response.header("Set-Cookie","Heroku-SessionId=SessionId-StoreCookie-None; Secure; SameSite=None");
        return "Store Cookies None";
    }

    public static String storeCookiesLax(Request request, Response response) {
        response.header("Set-Cookie","Heroku-Username=Anonymous-StoreCookie-Lax; Secure; SameSite=Lax");
        response.header("Set-Cookie","Heroku-SessionId=SessionId-StoreCookie-Lax; Secure; SameSite=Lax");
        return "Store Cookies Lax";
    }
}
