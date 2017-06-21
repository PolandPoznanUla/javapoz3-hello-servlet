package com.sda.homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-21.
 */
public class Client {
    public static void main(String[] args) throws IOException {
//        łączy się do servera
//        wysyła 5 liczb
//        odbiera wynik
//        wyświetla wynik
//        "192.168.100.109"


        Socket socket = new Socket("localhost", 1234);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(socket.getInputStream());
        Scanner scannerToUser = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("insert number ");
            writer.write(scannerToUser.nextLine() + "\n");
        }
        writer.flush();
        System.out.println("result is " + scanner.nextLine());
        socket.close();
    }
}
