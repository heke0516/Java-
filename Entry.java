package com.itheima.demo1;

import java.util.Scanner;

public class Entry {

    public Entry() {
    }

    public static void main(String[] args) {
        DormManager dormManager = new DormManager();

        int flag = 0;
        String name = "heke";
        String password = "111";
        int select;
        while(flag<3){
            System.out.println("请输入用户名");
            Scanner sc1 = new Scanner(System.in);
            String str1 = sc1.next();
            System.out.println("请输入密码");
            Scanner sc2 = new Scanner(System.in);
            String str2 = sc2.next();

            if(!str1.equals(name)||!str2.equals(password)) {
                flag++;
                if (flag <= 2) {
                    System.out.println("用户名或密码错误");
                }
            }
            if(flag==3){
                System.out.println("您的登录机会已用完！");
            }
            if(str1.equals(name)&&str2.equals(password)) {
                System.out.println("登录成功");

                do {
                    System.out.println("欢迎进入宿舍管理系统，请选择您要进行的操作：1.添加学生；2.删除学生；3.更新学生信息；4.查找学生信息；5.退出管理系统");
                    Scanner scanner = new Scanner(System.in);
                    select = scanner.nextInt();
                    switch (select) {
                        case 1 -> {
                            System.out.println("请输入您要添加的学生的姓名，床号和年龄，中间用英文逗号隔开：");
                            String data = scanner.next();
                            String[] dataArray = data.split(",");
                            DormMember dormMember = new DormMember();
                            dormMember.setName(dataArray[0]);
                            dormMember.setBednumber(dataArray[1]);
                            dormMember.setAge(Integer.parseInt(dataArray[2]));
                            dormManager.add(dormMember);
                            dormManager.print();
                        }
                        case 2 -> {
                            System.out.println("请输入您要删除的学生的床号：");
                            String number = scanner.next();
                            dormManager.deleteByNumber(number);
                            dormManager.print();
                        }
                        case 3 -> {
                            System.out.println("请选择您要更新的项目：1.姓名和年龄；2.仅姓名；3.仅年龄");
                            int select1 = scanner.nextInt();

                            if (select1 == 1) {
                                System.out.println("请输入床号，姓名，年龄，中间用英文逗号分隔：");
                                String data1 = scanner.next();
                                String dataArray1[] = data1.split(",");
                                DormMember dormMember = new DormMember(dataArray1[1], dataArray1[0], Integer.parseInt(dataArray1[2]));
                                dormManager.update(dormMember);
                                dormManager.print();
                            } else if (select1 == 2) {
                                System.out.println("床号，姓名，中间用英文逗号分隔：");
                                String data2 = scanner.next();
                                String dataArray2[] = data2.split(",");
                                dormManager.updateName(dataArray2[0],(dataArray2[1]));
                                dormManager.print();
                            } else if (select1 == 3) {
                                System.out.println("床号，年龄，中间用英文逗号分隔：");
                                String data3 = scanner.next();
                                String dataArray3[] = data3.split(",");
                                dormManager.updateAge(dataArray3[0],Integer.parseInt(dataArray3[1]));
                                dormManager.print();
                            }
                        }
                        case 4 -> {
                            System.out.println("请选择您查找的方式：1.姓名；2.床号");
                            int select2 = scanner.nextInt();
                            if (select2 == 1) {
                                System.out.println("请输入您要查找的姓名");
                                String name1 = scanner.next();
                                dormManager.print1(name1);
                            } else if (select2 == 2) {
                                System.out.println("请输入您要查找的床号");
                                String number = scanner.next();
                                dormManager.print2(number);
                            }
                        }
                    }
                } while (select != 5);
                break;
            }

            }




    }
}

