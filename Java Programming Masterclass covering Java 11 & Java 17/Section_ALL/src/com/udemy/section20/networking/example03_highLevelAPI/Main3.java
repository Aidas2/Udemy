package com.udemy.section20.networking.example03_highLevelAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main3 {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");

            URI uri = url.toURI();
            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());
            System.out.println();

/*            //version#1 to read (entire) url
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String line = "";
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();
*/
            //version#2 to read (entire) html
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            String line = "";
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch(URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        }

    }
}
