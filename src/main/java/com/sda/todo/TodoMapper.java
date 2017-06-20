package com.sda.todo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-12.
 */
public class TodoMapper {

    public static TodoModel map(HttpServletRequest req) {
        Map<String, String[]> map = req.getParameterMap();
        TodoModel todoModel = new TodoModel();
        todoModel.setName(map.get("name")[0]);
        todoModel.setDescription(map.get("description")[0]);
        todoModel.setChecked(getChecked(map));
        todoModel.setPriority(getPriority(map));
        todoModel.setDate(getDate(map));
        return todoModel;
    }

    public static TodoModel map(Scanner scanner) {
        return map(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
    }

    public static  TodoModel map(String title, String description, String status, String priority, String date) {

        TodoModel todoModel = new TodoModel();
        todoModel.setName(title);
        todoModel.setDescription(description);
//        todoModel.setChecked("true".equals(status));
        todoModel.setChecked(new Boolean(status));
//        todoModel.setChecked(Boolean.valueOf(status));
        todoModel.setPriority(Integer.parseInt(priority));
//        todoModel.setPriority(new Integer(priority));
        todoModel.setDate(LocalDate.parse(date));
        return todoModel;

    }

    public  static  String map(TodoModel todoModel) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(todoModel.getName() + "\r\n")
                .append(todoModel.getDescription() + "\r\n")
                .append(String.valueOf(todoModel.isChecked()) + "\r\n")
                .append(todoModel.getPriority() + "\r\n")
                .append(todoModel.getDate() + "\r\n")
                .toString();
    }

    private static LocalDate getDate(Map<String, String[]> map) {
        String dateAsString = map.get("date")[0];
        String[] split = dateAsString.split("-");
        return LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    private static int getPriority(Map<String, String[]> map) {
        return Integer.parseInt(map.get("priority")[0]);
    }

    private static boolean getChecked(Map<String, String[]> map) {
            return "on".equals(map.containsKey("checked"));
    }
}
