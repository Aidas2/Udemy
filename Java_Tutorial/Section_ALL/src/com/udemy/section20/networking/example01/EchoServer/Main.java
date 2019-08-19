package com.udemy.section20.networking.example01.EchoServer;


import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {

        /* //version for one client:
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            //for multiple clients this part will be cut and pasted in to while loop:
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);


            while (true) {
                String echoString = input.readLine();
                if (echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }


        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
         */

        /* //version#1 for multiple client (not very good)
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            while (true) {

                //for multiple clients this part is cut and pasted in to while loop:
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);


                String echoString = input.readLine();
                //this try/catch block is used to avoid some problems due blocking due waiting for input:
                try {
                  Thread.sleep(15000);
                } catch (InterruptedException e) {
                    System.out.println("Thead interrupted");
                }

                if (echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }

        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
*/

        //version#2 for multiple clients:
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                new Echoer(serverSocket.accept()).start();
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
            }


        } catch (
                IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }

    }

}
