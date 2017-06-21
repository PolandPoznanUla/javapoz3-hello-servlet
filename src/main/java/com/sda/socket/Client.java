package com.sda.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-20.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.100.109", 1234);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(socket.getInputStream());
        boolean flag = true;
        while(flag) {
            Scanner scannerToUser = new Scanner(System.in);
            writer.write(scannerToUser.nextLine() + "\n");
            writer.flush();
            System.out.println(scanner.nextLine());
        }
        socket.close();
    }
}
