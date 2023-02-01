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
			if(place.equals("һ�߳���")) {
				places = 0;
			}else if(place.equals("���߳���")){
				places = 1;
			}else if(place.equals("���߳���")){
				places = 2;
			}else if(place.equals("���߳���")){
				places = 3;
			}
			if(level.equals("��ͨԱ��")) {
				Staff employee = new Staff(name, places, traff, stays, day);
				totalMoney = employee.getTraffic() + employee.getPlaceMoney() + employee.getStayMoney() + employee.getStays();
				pw.print(employee.getName() + " " + totalMoney);
			}if(level.equals("����")) {
				Manager employee = new Manager(name, places, traff, stays, day);
				totalMoney = employee.getTraffic() + employee.getPlaceMoney() + employee.getStayMoney() + employee.getStays();
				pw.print(employee.getName() + " " + totalMoney);
			}if(level.equals("�߲�")) {
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
