package org.wso2.charon.samples.group.sample06;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class DeleteGroupSample {

    public static void main(String[] args) {

        //get the id of the user
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.print("Enter the group ID : ");
        String id = reader.next();
        try {
            String url = "http://localhost:8080/scim/v2/Groups/"  + id;;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Setting basic post request
            con.setRequestMethod("DELETE");
            con.setRequestProperty("Content-Type", "application/scim+json");


            // Send post request
            con.setDoOutput(true);

            int responseCode = con.getResponseCode();

            BufferedReader in;
            if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) { // success
                in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(
                        con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            //printing result from response
            System.out.println("Response Code : " + responseCode);
            System.out.println("Response Message : " + con.getResponseMessage());
            if (responseCode != HttpURLConnection.HTTP_NO_CONTENT) { // success
                System.out.println("Response Content : " + response.toString());

            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
