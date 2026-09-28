package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private List<Result> results = new ArrayList<>();

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Result> getResults() {
        return results;
    }

    public void addResult(Result result) {
        results.add(result);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', group='" + group + "'}";
    }
}