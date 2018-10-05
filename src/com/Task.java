package com;

import static com.Status.OPEN;

public class Task {

    private int id;
    private String name;
    private String reporter;
    private String project;
    private Status status = OPEN;
    private String note;

    public Task(String name, int id, String reporter, String project) {
        this.name = name;
        this.id = id;
        this.reporter = reporter;
        this.project = project;
    }

    public Task(String name, Status status, int id, String project, String reporter) {
        this(name, id, reporter, project);
        this.status= status;
    }

    public Task(String name, Status status, int id, String project, String reporter, String note) {
        this(name, status, id, project, reporter);
        this.note = note;
    }

    public Task(String name, int id, String reporter, String project, String note) {
        this(name, id, project, reporter);
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getReporter() {
        return reporter;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (!name.equals(task.name)) return false;
        if (!reporter.equals(task.reporter)) return false;
        if (!project.equals(task.project)) return false;
        if (status != task.status) return false;
        return note != null ? note.equals(task.note) : task.note == null;
    }

    @Override
    public String toString() {
        return "Task{" +
                " \n\tname =\t\t'" + name + '\'' +
                "\n\treporter =\t'" + reporter + '\'' +
                "\n\tproject =\t'" + project + '\'' +
                "\n\tid =\t\t " + id +
                "\n\tstatus =\t " + status +
                "\n\tnote =\t\t'" + (note==null?"null":note.replace("\n","\n\t\t\t\t ")) + '\'' +
                "\n}";
    }
}
