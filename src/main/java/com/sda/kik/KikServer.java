package com.sda.kik;

import com.sda.socket.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-20.
 */
public class KikServer {
    public static void main(String[] args) throws IOException {
//        Board board = new Board();
//        System.out.println(board);
//        board.addMove(5, "X");
//        System.out.println(board);
//        board.addMove(2, "O");
//        System.out.println(board);

        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();

        Scanner scanner = new Scanner(System.in);

        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner socketIn = new Scanner(socket.getInputStream());

        Board board = new Board();
        boolean status;
        boolean flag = true;
        while (flag) {
            System.out.println(board.toString());
            do {
                System.out.println("Insert position: ");
                String number = scanner.nextLine();
                status = board.addMove(Integer.valueOf(number), "X");
                if (status) {
                    socketOut.write(number + "\n");
                    socketOut.flush();
                } else {
                    System.out.println("Invalid position, try again");
                }
            } while (!status);
                String opponentPosition = socketIn.nextLine();
                board.addMove(Integer.valueOf(opponentPosition), "O");
            }
        }
    }

