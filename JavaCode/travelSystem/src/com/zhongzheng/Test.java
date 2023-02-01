package com.zhongzheng;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String name;
		String level;
		String place;
		int places = -1;
		double totalMoney = 0;
		Scanner input = new Scanner(new File("src/com/zhongzheng/source.txt"));
		PrintWriter pw = new PrintWriter(new File("result.txt"));
		
		while(input.hasNextLine()) {
			name = input.next();
			level = input.next();
			place = input.next();
			double traff = input.nextDouble();
			double stays = input.nextDouble();
			int day = input.nextInt();
			if(place.equals("一线城市")) {
				places = 0;
			}else if(place.equals("二线城市")){
				places = 1;
			}else if(place.equals("三线城市")){
				places = 2;
			}else if(place.equals("四线城市")){
				places = 3;
			}
			if(level.equals("普通员工")) {
				Staff employee = new Staff(name, places, traff, stays, day);
				totalMoney = employee.getTraffic() + employee.getPlaceMoney() + employee.getStayMoney() + employee.getStays();
				pw.print(employee.getName() + " " + totalMoney);
			}if(level.equals("主管")) {
				Manager employee = new Manager(name, places, traff, stays, day);
				totalMoney = employee.getTraffic() + employee.getPlaceMoney() + employee.getStayMoney() + employee.getStays();
				pw.print(employee.getName() + " " + totalMoney);
			}if(level.equals("高层")) {
				Leader employee = new Leader(name, places, traff, stays, day);
				totalMoney = employee.getTraffic() + employee.getPlaceMoney() + employee.getStayMoney() + employee.getStays();
				pw.print(employee.getName() + " " + totalMoney);
			}
			pw.print('\n');
			
		}
		pw.close();
		input.close();

	}

}
