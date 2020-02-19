/*
 * Created by Rufat Asadzade on 19.02.20 14:20
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz.registartion_package;

public class NewUserStruct {

   // public Boolean response;
    public String name;
    public String surname;
    public String mail;
    public String pass;
    public String phone;
    public String bDate;
    public String gender;
    public String country;
    public String city;
    public String sector;

    public NewUserStruct(String name, String surname, String mail, String pass, String phone,
                         String bDate, String gender, String country, String city, String sector) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.pass = pass;
        this.phone = phone;
        this.bDate = bDate;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.sector = sector;
    }
}
