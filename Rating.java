package com.itheima.demo1;

import java.io.File;
import java.util.Scanner;


public class Rating {
  private  String number;

    public Rating(){

    }
    int num;
    public int access(String number)  {
        String filePath = "D:\\exam\\"+number;
        File f = new File(filePath);
        if (f.exists() && f.isDirectory()) {
            System.out.println("该目录是存在的！");
            for (int i = 0; i < f.list().length; i++)
                System.out.println((f.list())[i]);
            File f1 = new File(f, "winkt");
            if (f1.exists() && f1.isDirectory()) {
                num = num + 6;
            }
            File f2 = new File(f, "readme.txt");
            if (f2.exists()) {
                num = num + 6;
            }
            File f3 = new File(f1, "abc.txt");
            File f4 = new File(f, "abc.txt");
            if (f3.exists() && f4.exists()) {
                num = num + 6;
            }
            File f5 = new File(f, "def.txt");
            File f6 = new File(f1, "def.txt");
            if (!f5.exists() && f6.exists()) {
                num = num + 6;
            }
            File f7 = new File(f, "123.txt");
            File f8 = new File(f1, "123.txt");
            if (!f7.exists() && !f8.exists()) {
                num = num + 6;
            }
        }
        return num;
    }
    public static void main(String[] args){
        Rating as=new Rating();
        System.out.println("请输入考号");
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int k=as.access(number);
        System.out.println("考生号为"+number+"的windows题目最终评分为："+k);
    }



}
