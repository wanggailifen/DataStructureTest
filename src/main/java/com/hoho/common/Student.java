package com.hoho.common;

public class Student implements Comparable<Student> {
    private String name;

    private int score;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Student another = (Student) o;

        return this.name.equals(another.name);
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return "Student(" +
                "name='" + name + '\'' +
                ", score=" + score +
                ')';
    }
}
