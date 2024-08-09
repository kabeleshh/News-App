package src.news;

import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
    private static final String api = "e1e3299336a24e33ab955656b37b0293";
    private static final String base_url = "https://newsapi.org/v2/top-headlines?";
    public static void main(String args[]){
        try{
                Scanner s = new Scanner(System.in);
                System.out.println("Enter the category : (Eg : technology,business,etc)");
                String str = s.nextLine();
                String base_api = base_url + "Category="+str+"&language=en&apikey="+api;

                @SuppressWarnings("deprecation")
                HttpURLConnection con = (HttpURLConnection) new URL(base_api).openConnection();
                con.setRequestMethod("GET");

                BufferedReader b = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line="";
                String json="";
                while((line=b.readLine())!=null){
                    json = json + line;
                }
                b.close();

                int index = 0;
                while ((index = json.indexOf("\"title\":\"", index)) != -1) {
                int startIndex = index + 9; // Move index to the start of the title value
                int endIndex = json.indexOf("\"", startIndex); // Find the end of the title value
                System.out.println("Title: " + json.substring(startIndex, endIndex));
                index = endIndex + 1; // Move index forward to continue searching
}

                s.close();
        }
        catch(Exception e){
            System.err.println("Error Message :"+e.getMessage());
        }
    }
}
