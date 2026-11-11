package ua.edu.op.nkpk.model;



public abstract class Person {

    private String name;


    protected Person(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public abstract String getRole();


    @Override
    public String toString() {
        return getRole() + "{name='" + name + "'}";
    }

    public String describe() {
        return getRole() + ": " + name;
    }
}