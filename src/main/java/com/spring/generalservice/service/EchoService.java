package com.spring.generalservice.service;

import com.google.gson.Gson;
import com.spring.generalservice.dao.EchoRequest;
import com.spring.generalservice.dao.EchoResponse;
import com.spring.generalservice.dao.PureEcho;
import spark.Request;
import spark.Response;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class EchoService {

    public static final String userName = "testU";
    public static final String password = "testP";

    public static EchoResponse processEcho(Request request, Response response) throws Exception {
        EchoRequest echoRequest = new Gson().fromJson(request.body(), EchoRequest.class);
        EchoResponse echoResponse = new EchoResponse();
        if( echoRequest == null ) {
            echoResponse.message = "Response : please use post method. ";
        } else {
            echoResponse.message = "Response : " + echoRequest.message;
        }
        return echoResponse;
    }

    public static EchoResponse processEchoDelay(Request request, Response response) throws Exception {
        EchoRequest echoRequest = new Gson().fromJson(request.body(), EchoRequest.class);
        System.out.println(" going to sleep ... for 50 seconds ");
        Thread.sleep(55000);
        System.out.println(" waking up from sleep");
        EchoResponse echoResponse = new EchoResponse();
        if( echoRequest == null ) {
            echoResponse.message = "Response : please use post method . ";
        } else {
            echoResponse.message = "Response : " + echoRequest.message;
        }
        return echoResponse;
    }

    private static Boolean isAuthenticated(Request request, Response response) {
        try {
            String header = request.headers("Authorization");
            assert header.substring(0, 6).equals("Basic ");
            String basicAuthEncoded = header.substring(6);
            String basicAuthAsString = new String(Base64.getDecoder().decode(basicAuthEncoded.getBytes()));
            if (basicAuthAsString.equals(userName + ":" + password)) {
                return true;
            } else {
                return false;
            }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static EchoResponse processEchoSecure(Request request, Response response) throws Exception {
        EchoRequest echoRequest = new Gson().fromJson(request.body(), EchoRequest.class);
        EchoResponse echoResponse = new EchoResponse();
        echoResponse.authenticated = isAuthenticated(request, response);
        if( echoRequest == null ) {
            echoResponse.message = "Response : please use post method. ";
        } else {
            echoResponse.message = "Response : " + echoRequest.message;
        }
        return echoResponse;
    }

    public static PureEcho processPureEcho(Request request, Response response) throws Exception {
        PureEcho pureEchoResponse = new PureEcho();
        if(request!=null){
           pureEchoResponse.setBody(request.body());
           String url = request.url();
           if(request.queryParams()!=null){
              url+="?";
              for(String queryParam : request.queryParams()){
                 url+=queryParam+"="+request.queryParams(queryParam)+"&";
              }
              url = url.substring(0,url.length()-1);
           }
           if(request.headers()!=null){
              Map<String,String> headers = new HashMap<>();
              for(String key: request.headers()){
                  headers.put(key, request.headers(key));
              }
              pureEchoResponse.setHeaders(headers);
           }
           pureEchoResponse.setUrl(url);
           pureEchoResponse.setStatus(response.status());
        }
        System.out.println("pureEcho response: "+pureEchoResponse);
        return pureEchoResponse;
    }

}
