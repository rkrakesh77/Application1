package com.example.myapplication1;

import com.google.gson.annotations.SerializedName;

public class Employee {
    @SerializedName("name")
    private  String name;
    @SerializedName("mail")
    private  String mail;
    @SerializedName("age")
    private  int age;

    public Employee(String name, String mail, int age) {
        this.name = name;
        this.mail = mail;
        this.age = age;
    }
}
