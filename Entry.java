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
            System.out.println("�������û���");
            Scanner sc1 = new Scanner(System.in);
            String str1 = sc1.next();
            System.out.println("����������");
            Scanner sc2 = new Scanner(System.in);
            String str2 = sc2.next();

            if(!str1.equals(name)||!str2.equals(password)) {
                flag++;
                if (flag <= 2) {
                    System.out.println("�û������������");
                }
            }
            if(flag==3){
                System.out.println("���ĵ�¼���������꣡");
            }
            if(str1.equals(name)&&str2.equals(password)) {
                System.out.println("��¼�ɹ�");

                do {
                    System.out.println("��ӭ�����������ϵͳ����ѡ����Ҫ���еĲ�����1.���ѧ����2.ɾ��ѧ����3.����ѧ����Ϣ��4.����ѧ����Ϣ��5.�˳�����ϵͳ");
                    Scanner scanner = new Scanner(System.in);
                    select = scanner.nextInt();
                    switch (select) {
                        case 1 -> {
                            System.out.println("��������Ҫ��ӵ�ѧ�������������ź����䣬�м���Ӣ�Ķ��Ÿ�����");
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
                            System.out.println("��������Ҫɾ����ѧ���Ĵ��ţ�");
                            String number = scanner.next();
                            dormManager.deleteByNumber(number);
                            dormManager.print();
                        }
                        case 3 -> {
                            System.out.println("��ѡ����Ҫ���µ���Ŀ��1.���������䣻2.��������3.������");
                            int select1 = scanner.nextInt();

                            if (select1 == 1) {
                                System.out.println("�����봲�ţ����������䣬�м���Ӣ�Ķ��ŷָ���");
                                String data1 = scanner.next();
                                String dataArray1[] = data1.split(",");
                                DormMember dormMember = new DormMember(dataArray1[1], dataArray1[0], Integer.parseInt(dataArray1[2]));
                                dormManager.update(dormMember);
                                dormManager.print();
                            } else if (select1 == 2) {
                                System.out.println("���ţ��������м���Ӣ�Ķ��ŷָ���");
                                String data2 = scanner.next();
                                String dataArray2[] = data2.split(",");
                                dormManager.updateName(dataArray2[0],(dataArray2[1]));
                                dormManager.print();
                            } else if (select1 == 3) {
                                System.out.println("���ţ����䣬�м���Ӣ�Ķ��ŷָ���");
                                String data3 = scanner.next();
                                String dataArray3[] = data3.split(",");
                                dormManager.updateAge(dataArray3[0],Integer.parseInt(dataArray3[1]));
                                dormManager.print();
                            }
                        }
                        case 4 -> {
                            System.out.println("��ѡ�������ҵķ�ʽ��1.������2.����");
                            int select2 = scanner.nextInt();
                            if (select2 == 1) {
                                System.out.println("��������Ҫ���ҵ�����");
                                String name1 = scanner.next();
                                dormManager.print1(name1);
                            } else if (select2 == 2) {
                                System.out.println("��������Ҫ���ҵĴ���");
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

