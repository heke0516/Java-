package com.itheima.demo1;

import java.util.ArrayList;
import java.util.List;

public class DormManager {
    /*private String name;
    private String password;*/
    private List<DormMember> dormMemberList;

    public List<DormMember> getdormMemberList() {
        return this.dormMemberList;
    }

    public void setDormMemberList(List<DormMember> dormMemberList) {
        this.dormMemberList = dormMemberList;
    }

    public DormManager(String name, String password) {
        /*this.name = name;
        this.password = password;*/
        this.dormMemberList = new ArrayList<DormMember>();
    }

    public DormManager() {
        this.dormMemberList = new ArrayList<DormMember>();
    }

    /*public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
*/

    public int findByName(String name) {
        for(int i = 0; i < this.dormMemberList.size(); ++i) {
            if (dormMemberList.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public int findByNumber(String number) {
        for(int i = 0; i < this.dormMemberList.size(); ++i) {
            if (dormMemberList.get(i).getBednumber().equals(number)) {
                return i;
            }
        }

        return -1;
    }

    public boolean add(DormMember student) {
        if (this.findByName(student.getBednumber()) == -1) {
            dormMemberList.add(student);
            return true;
        } else {
            System.out.println("学号已存在，请重新添加！");
            return false;
        }
    }


    public boolean deleteByNumber(String bednumber) {
        int index = findByNumber(bednumber);
        if (index != -1) {
            this.dormMemberList.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(DormMember dormMember) {
        return dormMemberList.remove(dormMember);
    }

    public boolean update(DormMember dormMember) {
        int index = findByNumber(dormMember.getBednumber());
        if (index != -1) {
            dormMemberList.get(index).setName(dormMember.getName());
            dormMemberList.get(index).setAge(dormMember.getAge());
            return true;
        } else {
            return false;
        }
    }

    public boolean updateName(String number, String name) {
        int index = this.findByNumber(number);
        if (index != -1) {
            dormMemberList.get(index).setName(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateAge(String number, int age) {
        int index = this.findByNumber(number);
        if (index != -1) {
            dormMemberList.get(index).setAge(age);
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        for(int i = 0; i < dormMemberList.size();i++) {
            System.out.println(dormMemberList.get(i));
        }

    }
    public void print1(String name){
        int key = findByName(name);
        System.out.println(dormMemberList.get(key));
    }

    public void print2(String number){
        int key = findByNumber(number);
        System.out.println(dormMemberList.get(key));
    }


}

