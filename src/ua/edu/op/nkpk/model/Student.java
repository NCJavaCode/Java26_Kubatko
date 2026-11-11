package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;


public class Student extends Person {

    private String group;


    private List<Result> results = new ArrayList<>();


    public Student(String name, String group) {
        super(name);
        this.group = group;
    }


    @Override
    public String getRole() {
        return "Student";
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


    public double getAverageScore() {
        if (results.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < results.size(); i++) {
            sum += results.get(i).getScore();
        }
        return (double) sum / results.size();
    }

    @Override
    public String toString() {
        return "Student{name='" + getName() + "', group='" + group + "'}";
    }
}