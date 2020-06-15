package ru.otus.spring.domain;

public class Student {

    private String firstName;
    private String lastName;
    private int testResult;

    public Student(){
    }

    public Student(String firstName, String lastName, int testResult) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testResult = testResult;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student setTestResult(int testResult) {
        this.testResult = testResult;
        return this;
    }

    public int getTestResult() {
        return testResult;
    }
}
