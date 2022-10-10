package com.itheima.demo1;

public class DormMember {
    private String name;
    private String bednumber;
    private int age;

    public DormMember(String name, String bednumber, int age) {
        super();
        this.name = name;
        this.bednumber = bednumber;
        this.age = age;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DormMember) {
            DormMember s = (DormMember) obj;
            return this.age == s.age && this.name.equals(s.name) && this.bednumber.equals(s.bednumber);
        } else {
            return false;
        }
    }

    public DormMember() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBednumber() {
        return this.bednumber;
    }

    public void setBednumber(String bednumber) {
        this.bednumber = bednumber;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String toString() {
        return "Student [name=" + this.name + ", bednumber=" + this.bednumber + ", age=" + this.age + "]";
    }
}
