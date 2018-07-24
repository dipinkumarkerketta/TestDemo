package com.test.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.io.*;
 
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
 
public class HttpsTest{
 
  public static void main(String[] args)
  {
     new HttpsTest().byPassSSl("");
  }
 
  private TrustManager[ ] get_trust_mgr() {
     TrustManager[ ] certs = new TrustManager[ ] {
        new X509TrustManager() {
           public X509Certificate[ ] getAcceptedIssuers() { return null; }
           public void checkClientTrusted(X509Certificate[ ] certs, String t) { }
           public void checkServerTrusted(X509Certificate[ ] certs, String t) { }
         }
      };
      return certs;
  }
 
  public StringBuilder byPassSSl( String url1){
	   HttpsURLConnection con=null;
     String https_url = url1;
     URL url;
     try {
 
	    // Create a context that doesn't check certificates.
            SSLContext ssl_ctx = SSLContext.getInstance("TLS");
            TrustManager[ ] trust_mgr = get_trust_mgr();
            ssl_ctx.init(null,                // key manager
                         trust_mgr,           // trust manager
                         new SecureRandom()); // random number generator
            HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());
 
	    url = new URL(https_url);
	    con = (HttpsURLConnection)url.openConnection();
 
	    // Guard against "bad hostname" errors during handshake.
            con.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String host, SSLSession sess) {
                    return true;
                }
            });
            
            
            
           /* con.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String host, SSLSession sess) {
                    if (host.equals("localhost")) return true;
                    else return false;
                }
            });*/
 
	    //dumpl all cert info
	    print_https_cert(con);
 
	    //dump all the content
	  // System.out.println( print_content(con).toString());
	    
 
	 } catch (MalformedURLException e) {
		e.printStackTrace();
	 } catch (IOException e) {
		e.printStackTrace();
	 }catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	 }catch (KeyManagementException e) {
		e.printStackTrace();
      }	
	 return     print_content(con);
   }
 
  private void print_https_cert(HttpsURLConnection con){
     /*if(con!=null){
 
     try {
 
	System.out.println("Response Code : " + con.getResponseCode());
	System.out.println("Cipher Suite : " + con.getCipherSuite());
	System.out.println("\n");
 
	Certificate[] certs = con.getServerCertificates();
	for(Certificate cert : certs){
	  System.out.println("Cert Type : " + cert.getType());
	  System.out.println("Cert Hash Code : " + cert.hashCode());
	  System.out.println("Cert Public Key Algorithm : " + cert.getPublicKey().getAlgorithm());
	  System.out.println("Cert Public Key Format : " + cert.getPublicKey().getFormat());
	  System.out.println("\n");
	}
 
 
     } catch (SSLPeerUnverifiedException e) {
	  e.printStackTrace();
     } catch (IOException e){
	  e.printStackTrace();
     }	   
   }		*/
  }
 
  private StringBuilder print_content(HttpsURLConnection con){
		InputStreamReader inputStreamReader = null;
		StringBuilder builder = new StringBuilder("");
    if(con!=null){
    	int a = 0;
    
    try {
 
	
 
	inputStreamReader = new InputStreamReader(con.getInputStream());
 
	while ((a = inputStreamReader.read()) > 0) {
		
		builder.append((char) a);
		//System.out.print((char) a);
	}
 
     } catch (IOException e) {
	e.printStackTrace();
     }		
   }
    return builder;
  }
 
}
