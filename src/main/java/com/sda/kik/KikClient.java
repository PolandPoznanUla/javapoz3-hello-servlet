package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-20.
 */

//  zd dom stworzyc boardUtils i wyciagnac powtarzalny kod z klienta i servera
//   wyszlifować do repo

public class KikClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.100.109", 1234);

        Scanner scannerToUser = new Scanner(System.in);

        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Board board = new Board();
        System.out.println("Waiting for first move: ");
        while (!board.isGameFinished()) {
            if (board.getCounter() % 2 == 0) {
                opponentsTurn(socketIn, board);
            } else {
                yourTurn(scannerToUser, socketOut, board);

//                board.addMove(ourPositionNumber, "O");
//                socketOut.write(ourPositionNumber + "\n");
//                socketOut.flush();
            }
        }
    }

    private static void yourTurn(Scanner scannerToUser, BufferedWriter socketOut, Board board) throws IOException {
        boolean status;
        do {
            System.out.println("Insert position :");
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
    }

    private static void opponentsTurn(Scanner socketIn, Board board) {
        String opponentPosition = socketIn.nextLine();
        Integer position = Integer.valueOf(opponentPosition);

        board.addMove(position, "X");

        System.out.println(board);
    }
}
