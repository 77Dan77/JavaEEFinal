package com.example.final_jee.Utils;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class DBCreate {
        public static String createDataBaseSql(){
            return "DROP TABLE IF EXISTS demo; " +
                    "CREATE TABLE demo (ID integer primary key" +
                    ", Name varchar(20), " +
                    "Hint varchar(200) ); \n" +
                    ""
                    +
                    "DROP TABLE IF EXISTS Admin; " +
                    "CREATE TABLE Admin (id integer primary key" +
                    ", name varchar(20)); \n" +
                    ""
                    +
                    "DROP TABLE IF EXISTS Customer; " +
                    "CREATE TABLE Customer (id integer primary key" +
                    ", name varchar(20), " +
                    "status boolean); \n" +
                    ""
                    +
                    "DROP TABLE IF EXISTS Cameras; " +
                    "CREATE TABLE Cameras (id integer primary key" +
                    ", brand varchar(20)," +
                    " model varchar(20)," +
                    " price numeric," +
                    " numberOfItems integer); \n" +
                    ""
                    +
                    "DROP TABLE IF EXISTS Laptops; " +
                    "CREATE TABLE Laptops (id integer primary key" +
                    ", brand varchar(20)," +
                    " model varchar(20)," +
                    " price numeric," +
                    " numberOfItems integer); \n" +
                    ""
                    +
                    "DROP TABLE IF EXISTS Phones; " +
                    "CREATE TABLE Phones (id integer primary key" +
                    ", brand varchar(20)," +
                    " model varchar(20)," +
                    " price numeric," +
                    " numberOfItems integer); \n" +
                    ""
                    ;
        }



        public static String selectFromDataBase(){
            return "SELECT * FROM demo";
        }

        public static List<String> LocalData(){
            List<String> array = new ArrayList<>();
            array.add("insert into demo values(1,'SQL Online','for Data Science');");
            array.add("insert into demo values(2,'Kirill N.','https://www.linkedin.com/in/sqliteonlinecom');");
            array.add("insert into demo values(3,'Twitter','https://twitter.com/SqliteOnlineCom');");
            array.add("insert into demo values(4,'Chart','LINE-SELECT name, cos(id), sin(id) FROM demo');");
            array.add("insert into demo values(6,'SqLite 3.36.0','SQL OnLine on JavaScript');");
            array.add("insert into demo values(7,'[RightClick] mouse','Opens many additional features');");
            array.add("insert into demo values(8,'Left-Panel, Table','[RightClick] mouse ''Context menu');");
            array.add("insert into demo values(9,'Tabs','mouse: [RightClick] , [MiddleClick] , [Wheel] , [LeftClick]');");

            array.add("insert into Admin values(1, 'Daniyal');");

            array.add("insert into Customer values(1, 'Sanya', 'true');");
            array.add("insert into Customer values(2, 'Nurbol', 'true');");
            array.add("insert into Customer values(3, 'Ramazan', 'false');");
            array.add("insert into Customer values(4, 'Alibek', 'true');");
            array.add("insert into Customer values(5, 'Orazali', 'false');");

            array.add("insert into Cameras values(1, 'Nikon', 'D5600', 250000, 5);");
            array.add("insert into Cameras values(2, 'Nikon', 'D4',600000, 3);");
            array.add("insert into Cameras values(3, 'Canon', 'Mark 3', 590000, 4);");
            array.add("insert into Cameras values(4, 'Sony', 'A7', 720000, 2);");
            array.add("insert into Cameras values(5, 'Canon', 'eos 250', 220000, 10);");
            array.add("insert into Cameras values(6, 'Panasonic', 'GR3', 315990, 4);");
            array.add("insert into Cameras values(7, 'Leica', '9', 469990, 1);");

            array.add("insert into Phones values(1, 'Samsung', 'S21', 599000, 6);");
            array.add("insert into Phones values(2, 'Samsung', 'Note 20Pro',659900, 5);");
            array.add("insert into Phones values(3, 'iPhone', '13XS', 799900, 10);");
            array.add("insert into Phones values(4, 'Sony', 'xPeria x5', 530000, 3);");
            array.add("insert into Phones values(5, 'Xiaomi', 'Mi11', 369000, 20);");
            array.add("insert into Phones values(6, 'Huawei', 'P40Pro', 389000, 14);");
            array.add("insert into Phones values(7, 'Xiaomi', 'Mi Mix4', 420000, 7);");

            array.add("insert into Laptops values(1, 'Asus', 'Rock5', 699000, 4);");
            array.add("insert into Laptops values(2, 'Xiaomi', 'MiBook2',559900, 5);");
            array.add("insert into Laptops values(3, 'McBook', '14`pro', 899900, 5);");
            array.add("insert into Laptops values(4, 'McBook', '15.6', 1099000, 2);");
            array.add("insert into Laptops values(5, 'Asus', 'ZenBook3', 469000, 10);");
            array.add("insert into Laptops values(6, 'Acer', 'PuckPuck2', 389000, 10);");
            array.add("insert into Laptops values(7, 'Lenovo', 'Legion', 520000, 5);");
            return array;
        }
    }