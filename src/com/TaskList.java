package com;



import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> list;
    private String project;

    public TaskList(@NotNull String project) {
        this.project = project;
        list = new ArrayList<>();

    }

    public TaskList(@NotNull String project, ArrayList<Task> list) {
        this.project = project;
        this.list = list;
    }

    @NotNull
    public String getProject() {
        return project;
    }

    public Task get(int index) {
        return list.get(index);
    }

    public boolean addTask(Task task) {
        if (this.contains(task) || task == null)
            return false;
        list.add(task);
        return true;
    }

    public boolean removeTask(Task task) {
        if (!this.contains(task))
            return false;
        list.remove(task);
        return true;
    }

    public boolean contains(Task task) {
        for (Task t: list) {
            if (t.equals(task))
                return true;
        }
        return false;
    }

    public int size() {
        return list.size();
    }


}
