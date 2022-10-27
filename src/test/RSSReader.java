/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import java.io.*;
import java.net.*;
/**
 *
 * @author ThinkPad
 */
public class RSSReader {
    public static void main(String[] args) {
        System.out.println(readRSS("http://rss.cnn.com/rss/edition_space.rss"));
    }
    public static String readRSS(String urlAddress) {
        try{
      URL rssUrl = new URL(urlAddress) ;
      BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
      String sourceCode = "";
      String line;
      while((line = in.readLine())!=null){
        if(line.contains("<title>")){
            int firstPos = line.indexOf("<title>");
            String temp = line.substring(firstPos);
            temp = temp.replace("<title>","");
            int lastPos = temp.indexOf("</title>");
            temp = temp.substring(0,lastPos);
            sourceCode += temp+"\n";
            
            
        }
    }
    in.close(); 
    return sourceCode;
    } catch(MalformedURLException ue){
            System.out.println("malformed url");
            
    }catch (IOException ioe) {
            System.out.println("something wrong");
    }
        return null;
    
}
}