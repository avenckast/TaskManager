package com;

import static com.Status.ON_HOLD;

public class Main {
    public static void main(String[] args) {
//        Task task = new Task("Wrong server selection", ON_HOLD, 6073, "VCPE", "Vladimir Artemov", "Ошибка воспроизводится только через UI.\nПодождать пока Владимир починит конфигурацию 2-18.");
//        TaskList list = new TaskList("PSUP");
//        list.addTask(task);
//        list.addTask(new Task("Wrong server selection", ON_HOLD, 6073, "VCPE", "Vladimir Artemov", "Уточнить актуальна ли ошибка"));
//        System.out.println(list.size());
//        System.out.println(task);
        TaskList list = new TaskList(null);
        list.addTask(new Task("a",2,"c","d"));
        System.out.println(list.getProject());
    }
}
