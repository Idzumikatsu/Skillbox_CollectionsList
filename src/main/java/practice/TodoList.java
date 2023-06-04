package practice;

import java.util.ArrayList;

public class TodoList {

    ArrayList<String> list = new ArrayList<>();
    public final String WARNING = "Дело с таким номером не существует";

    public String getString(int index) {
        if (isInList(index)){
            return list.get(index);
        } else {
            return WARNING;
        }
    }

    public void add(String todo) {
        list.add(todo);
    }

    public void add(int index, String todo) {
        if (isInList(index)) {
            list.add(index, todo);
        } else {
            list.add(todo);
        }
    }

    public void edit(int index, String todo) {
        if (isInList(index)) {
            list.set(index, todo);
        } else {
            System.out.println(WARNING);
        }
    }

    public void delete(int index) {
        if (isInList(index)) {
            list.remove(index);
        } else {
            System.out.println(WARNING);
        }
    }

    private boolean isInList(int index) {
        return !(index > list.size() - 1) && !(index < 0);
    }

    public ArrayList<String> getTodos() {
        return list;
    }
}