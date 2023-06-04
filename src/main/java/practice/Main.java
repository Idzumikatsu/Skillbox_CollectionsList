package practice;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isDigit;
        boolean isOn = true;

        while (isOn) {

            String input = scanner.nextLine();
            input = input.strip();
            String[] token = input.split(" ");
            StringBuilder sb = new StringBuilder();
            String command = token[0];

            switch (command) {
                case "LIST" -> {
                    var toDos = todoList.getTodos();
                    for (int i = 0; i < toDos.size(); i++) {
                        String s = String.valueOf(i)
                                .concat(" - ")
                                .concat(toDos.get(i));
                        System.out.println(s);
                    }
                }
                case "ADD" -> {
                    isDigit = Character.isDigit(token[1].charAt(0)) & token[1].matches("[0-9]+");
                    int index;
                    String text = null;
                    if (isDigit) {
                        index = Integer.parseInt(token[1]);
                        for (int i = 2; i < token.length; i++) {
                            text = sb.append(token[i]).append(" ").toString();
                        }
                        todoList.add(index, text);
                    } else {
                        for (int i = 1; i < token.length; i++) {
                            text = sb.append(token[i]).append(" ").toString();
                        }
                        todoList.add(text);
                    }
                    System.out.printf("Добавлено дело \"%s\"", Objects.requireNonNull(text).strip());
                }
                case "EDIT" -> {
                    String text = "";
                    isDigit = Character.isDigit(token[1].charAt(0)) & token[1].matches("[0-9]+");
                    if (isDigit){
                        int index = Integer.parseInt(token[1]);
                        for (int i = 2; i < token.length; i++) {
                            text = sb.append(token[i]).append(" ").toString();
                        }
                        if (!todoList.getString(index).equals(todoList.WARNING)){
                            System.out.printf(
                                    "Дело \"%s\" заменено на \"%s\"",
                                    todoList.getString(index).strip(),
                                    text.strip());
                            todoList.edit(index,text);
                        } else {
                            System.out.println(todoList.WARNING);
                        }
                    }
                }
                case "DELETE" -> {
                    isDigit = Character.isDigit(token[1].charAt(0)) & token[1].matches("[0-9]+");
                    if (isDigit){
                        int index = Integer.parseInt(token[1]);
                        if (!todoList.getString(index).equals(todoList.WARNING)){
                            System.out.printf(
                                    "Дело \"%s\" удалено",
                                    todoList.getString(index).strip());
                            todoList.delete(index);
                        } else {
                            System.out.println(todoList.WARNING);
                        }
                    }
                }
                case "END" -> isOn = false;
            }
        }
    }
}
