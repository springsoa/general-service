package com.spring.generalservice.dao;

import java.util.Map;

public class PureEcho {
   private String url;
   private String body;
   private int status;
   private Map<String,String> headers;

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getBody() {
      return body;
   }

   public void setBody(String body) {
      this.body = body;
   }

   public int getStatus() {
      return status;
   }

   public void setStatus(int status) {
      this.status = status;
   }

   public Map<String, String> getHeaders() {
      return headers;
   }

   public void setHeaders(Map<String, String> headers) {
      this.headers = headers;
   }

   @Override
   public String toString() {
      return "PureEcho{" +
        "url='" + url + '\'' +
        ", body='" + body + '\'' +
        ", status=" + status +
        ", headers=" + headers +
        '}';
   }
}
