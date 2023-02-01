package com.zhongzheng.出差系统;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int 高层 = 0,主管 = 1,普通员工 = 2;
        final int 一线城市  = 0,二线城市 = 1,三线城市 = 2,四线城市 = 3;
        String numberOfEmployee = "1";
        int employeeGreat;
        int cityGreat;

        double trafficExpense;
        double stayMany;
        int day;
        String[] number = new String[6];



        File source = new File("D:/source.txt");
        Scanner input = new Scanner(source);
        while(input.hasNextLine()){
            numberOfEmployee = input.next();
            for(int i = 0;i<5;i++){
                number[i] = input.next();
            }
            System.out.println(number[1].equalsIgnoreCase("二线城市"));
//            Subsidy subsidy = new Subsidy(numberOfEmployee, number[0], number[1], number[2], number[3], number[4]);
//            System.out.println(subsidy.subsidyMany());

        }

            System.out.println(111);
            input.close();


    }
}
