package com.spring.generalservice.dao;

public class PureEcho {
   private String url;
   private String payload;
   private int status;

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getPayload() {
      return payload;
   }

   public void setPayload(String payload) {
      this.payload = payload;
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
        ", payload='" + payload + '\'' +
        ", status=" + status +
        '}';
   }
}
