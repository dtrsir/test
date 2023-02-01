package com.zhongzheng.出差系统;

public class City {
    public final static int one  = 0,two = 1,three = 2,four = 3;
    private int great;
    private double many;

    public City() {
        super();
    }

    public City(int great) {
        this.great = great;
        if(great == one){
            many = 90;
        }else if(great == two){
            many = 70;
        }else if(great == three || great == four){
            many = 60;
        }else{
            System.out.printf("输入的城市等级无效");
        }
    }

    public int getGreat() {
        return great;
    }
}
