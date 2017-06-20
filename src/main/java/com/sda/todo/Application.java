package com.sda.todo;

import java.util.Scanner;

/**
 * Created by RENT on 2017-06-19.
 */
public class Application {
    public static void main(String[] args) {
        TodoDao todoDao = new TodoDaoMock();
        TodoView todoView = new TodoViewHtml();
        TodoChain todoChain = new TodoChain(todoView, todoDao);

        Scanner scanner = new Scanner(System.in);
        System.out.println("/all Show all");
        System.out.println("/add Add");
        String answer = scanner.nextLine();
//        todoChain.invoke(answer);


    }
}
