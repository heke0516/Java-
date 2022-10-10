package com.itheima.demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


class TimeException extends Exception{

}

public class FakeSignin {
    String beginTime;
    public FakeSignin(String beginTime){
        this.beginTime=beginTime;
    }

    public String getEndTime() throws TimeException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        Date now = new Date();
        String data1=sdf.format(now);
        boolean k=data1.compareTo(beginTime)>0;
        if (!k) {
            Date data = sdf.parse(beginTime);
            c.setTime(data);
            c.add(Calendar.MINUTE, 30);
            String t = sdf.format(c.getTime());
            return t;
        }else{
            throw new TimeException();
        }
    }

    public static void main(String arg[])  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        System.out.println("当前时间为:"+sdf.format(now));
        System.out.println("请输入签到开始时间:");
        Scanner sc=new Scanner(System.in);
        String time=sc.nextLine();
        FakeSignin timeUtil=new FakeSignin(time);
        try{
            System.out.println("签到结束时间为:"+timeUtil.getEndTime());
        } catch (TimeException e) {
            System.out.println("签到时间不得早于当前时间！");
        }catch(ParseException e){
            System.out.println("解析异常！");
        }

    }
}
