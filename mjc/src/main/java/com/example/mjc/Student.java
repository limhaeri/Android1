package com.example.mjc;

public class Student {
    private String name;
    private String phone;
    private int face;

    public Student(String name, String phone, int face) {
        this.name = name;
        this.phone = phone;
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getFace() {
        return face;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFace(int face) {
        this.face = face;
    }
}
