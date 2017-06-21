package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-20.
 */
public class KikClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.100.109", 1234);

        Scanner scannerToUser = new Scanner(System.in);

        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Board board = new Board();
        boolean flag = true;
        System.out.println("Waiting for first move: ");
        while (flag) {
            String opponentPosition = socketIn.nextLine();
            Integer position = Integer.valueOf(opponentPosition);

                board.addMove(position, "X");

                System.out.println(board);
                System.out.println("Insert position :");

                boolean status;
                do {
                    String ourPosition = scannerToUser.nextLine();
                    Integer ourPositionNumber = Integer.valueOf(ourPosition);
                    status = board.addMove(ourPositionNumber, "O");
                    if(status) {
                        socketOut.write(ourPositionNumber + "\n");
                        socketOut.flush();
                    } else {
                        System.out.println("Invalid position");
                        System.out.println("Try again");
                    }
                } while (!status);
//                board.addMove(ourPositionNumber, "O");
//                socketOut.write(ourPositionNumber + "\n");
//                socketOut.flush();

        }

    }
}
