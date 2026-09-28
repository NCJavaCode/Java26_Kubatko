package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private List<Test> tests = new ArrayList<>();

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Test> getTests() { return tests; }

    public Test createTest(String title) {
        Test test = new Test(title, this);
        tests.add(test);
        return test;
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "'}";
    }
}
