package com.sda.homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-21.
 */
public class Server {
    public static void main(String[] args) throws IOException {
//        dostaje 5 liczb przez socket
//        sumuje
//        oddaje sume
        ServerSocket serverSocket = new ServerSocket(1234);
        boolean flag = true;

        while(flag) {
            System.out.println("Waiting for connection");
        Socket socket = serverSocket.accept();

        Scanner scanner = new Scanner(socket.getInputStream());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

//            int[] array = new int[5];
            int sum = 0;
            for (int i = 0; i < 5; i++) {

                String input = scanner.nextLine();
                System.out.println(input);
                Integer integer = Integer.valueOf(input);
                sum += integer;

//                array[i] = Integer.parseInt(input);
//                System.out.println("Number " + i + " : " + input + "\n");
//                sum += array[i];

            }
            writer.write( sum + "\n");
            System.out.println("Flushing output");
            writer.flush();

            socket.close();
        }
        serverSocket.close();
    }

}
