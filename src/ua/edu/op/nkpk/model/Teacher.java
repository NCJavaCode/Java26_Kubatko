package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;


public class Teacher extends Person {

    private List<Test> tests = new ArrayList<>();


    public Teacher(String name) {
        super(name);
    }


    @Override
    public String getRole() {
        return "Teacher";
    }


    public List<Test> getTests() {
        return tests;
    }


    public Test createTest(String title) {
        Test test = new Test(title, this);
        tests.add(test);
        return test;
    }


    public Test findTestByTitle(String title) {
        int i = 0;
        while (i < tests.size()) {
            if (tests.get(i).getTitle().equalsIgnoreCase(title)) {
                return tests.get(i);
            }
            i++;
        }
        return null;
    }
}