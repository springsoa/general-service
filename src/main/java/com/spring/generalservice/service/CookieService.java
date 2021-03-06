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
        return "Cookies are Stored with  <b> no Same Site attribute </b> <br/> Heroku-Username : Anonymous-StoreCookie <br/> Heroku-SessionId : SessionId-StoreCookie ";
    }

    public static String storeCookiesNone(Request request, Response response) {
        response.header("Set-Cookie","Heroku-Username=Anonymous-StoreCookie-None; Secure; SameSite=None");
        response.header("Set-Cookie","Heroku-SessionId=SessionId-StoreCookie-None; Secure; SameSite=None");
        return "Cookies are Stored with SameSite = <b> None </b> <br/> Heroku-Username : Anonymous-StoreCookie-None <br/> Heroku-SessionId : SessionId-StoreCookie-None ";
    }

    public static String storeCookiesLax(Request request, Response response) {
        response.header("Set-Cookie","Heroku-Username=Anonymous-StoreCookie-Lax; Secure; SameSite=Lax");
        response.header("Set-Cookie","Heroku-SessionId=SessionId-StoreCookie-Lax; Secure; SameSite=Lax");
        return "Cookies are Stored with SameSite = <b> Lax </b> <br/> Heroku-Username : Anonymous-StoreCookie-Lax <br/> Heroku-SessionId : SessionId-StoreCookie-Lax ";
    }

    public static String storeCookiesStrict(Request request, Response response) {
        response.header("Set-Cookie","Heroku-Username=Anonymous-StoreCookie-Strict; Secure; SameSite=Strict");
        response.header("Set-Cookie","Heroku-SessionId=SessionId-StoreCookie-Strict; Secure; SameSite=Strict");
        return "Cookies are Stored with SameSite = <b> Strict </b> <br/> Heroku-Username : Anonymous-StoreCookie-Strict <br/> Heroku-SessionId : SessionId-StoreCookie-Strict ";
    }
}
