package com.zhongzheng.������¼;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import javafx.util.converter.LocalDateStringConverter;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Value baishikele = new Value(1001, "���¿���", "����", 4.5, 100);
		Value kekokele = new Value(1002, "�ɿڿ���", "����", 4.0, 100);
		Value baishixuebi = new Value(1003, "����ѩ��", "����", 3.8, 100);
		
		System.out.println(baishikele.toString());
		System.out.println(kekokele.toString());
		System.out.println(baishixuebi.toString());
		
		int serialNumber=1, numbers;
		OutPutDate op = new OutPutDate();
		Scanner input = new Scanner(System.in);
		
		while(serialNumber!=0) {
			System.out.println("��������Ʒ��ţ�");
			serialNumber = input.nextInt();
			
			if(serialNumber == 1001) {
				System.out.println(baishikele.nowToString());
				System.out.println("���������������");
				numbers = input.nextInt();
				op.outPutDate(serialNumber, baishikele.getName(), baishikele.getPeopleName(), baishikele.getManey(), numbers);
				baishikele.setNumber(numbers);
			}else if(serialNumber == 1002){
				System.out.println(kekokele.nowToString());
				System.out.println("���������������");
				numbers = input.nextInt();
				op.outPutDate(serialNumber, kekokele.getName(), kekokele.getPeopleName(), kekokele.getManey(), numbers);
				kekokele.setNumber(numbers);
			}else if(serialNumber == 1003){
				System.out.println(baishixuebi.nowToString());
				System.out.println("���������������");
				numbers = input.nextInt();
				op.outPutDate(serialNumber, baishixuebi.getName(), baishixuebi.getPeopleName(), baishixuebi.getManey(), numbers);
				baishixuebi.setNumber(numbers);
			}
		}
		input.close();
				
	}

}
