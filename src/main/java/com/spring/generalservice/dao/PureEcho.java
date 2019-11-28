package com.spring.generalservice.dao;

public class PureEcho {
   private String url;
   private String body;
   private int status;

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

   @Override
   public String toString() {
      return "PureEcho{" +
        "url='" + url + '\'' +
        ", body='" + body + '\'' +
        ", status=" + status +
        '}';
   }
}
