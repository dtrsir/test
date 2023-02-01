package com.zhongzheng.���ݽṹ;

import java.util.Scanner;

public class SeqList {
	private int[] date = new int[10];
	private int Lenght;
	private Integer x;

	public SeqList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public int[] getDate() {
		return date;
	}

	public void setDate(int[] date) {
		this.date = date;
	}

	public int getLenght() {
		return Lenght;
	}

	public void setLenght(int lenght) {
		Lenght = lenght;
	}

	/* ��ʼ��˳��� */
	public void InitList() {
		this.setLenght(0);
	}

	/* ����˳��� */
	public void createList(int n) {
		System.out.print("������" + n + "��������");
		int[] date = new int[n];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			date[i] = input.nextInt();
		}
//		input.close();
		this.setDate(date);
		this.setLenght(n);
	}

	/* ���Ҳ��� */
	public int getElem(int i, int x) {
		if (i < 1 || i > this.getLenght()) {
			System.out.println("����λ�ó���");
			return 0;
		} else {
			x = this.getDate()[i - 1];
			return 1;
		}
	}

	/* �����±� */
	public int locate(int x) {
		for (int i = 0; i < this.getLenght(); i++) {
			if (this.getDate()[i] == x) {
				return i - 1;
			} else {
				System.out.println("���޴�Ԫ��");
				return 0;
			}
		}
		return 0;
	}

	/* ����Ԫ�� */
	public int insElem(int i, int x) {
		if (this.getLenght() >= 10) {
			System.out.println("˳�����������ʧ��");
			return 0;
		}
		if (i - 1 >= this.getLenght()) {
			System.out.println("����λ�ó���");
			return 0;
		}
		if (i - 1 == this.getLenght()) {
			this.getDate()[i - 1] = x;
			System.out.println("�ڱ�β����");
			return 1;
		}
		for (int j = this.getLenght(); j > i - 1; j--) {
			this.getDate()[j - 1] = this.getDate()[j];
		}
		this.getDate()[i - 1] = x;
		this.setLenght(this.getLenght() + 1);
		System.out.println("���в���ɹ�");
		return 1;
	}

	/* ɾ��Ԫ�� */
	public int delElem(int i, Integer x) {
		if (this.getLenght() == 0) {
			System.out.println("��Ϊ�գ��޷�ɾ��");
			return 0;
		}
		if (i < 1 || i - 1 > this.getLenght()) {
			System.out.println("ɾ��λ�ó���");
			return 0;
		}
		x = this.getDate()[i - 1];
		for (int j = i; j <= this.getLenght(); j++) {
			this.getDate()[j - 1] = this.getDate()[j];
		}
		this.setLenght(this.getLenght() - 1);
		System.out.println("ɾ���ɹ�");
		return 1;
	}

	/* ���Ԫ�� */
	public void dispList() {
		for (int x : this.getDate()) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SeqList sl = new SeqList();
		boolean ex = true;
		int number = 0;
		Scanner input = new Scanner(System.in);
		while (ex) {
			System.out.println("======================================================");
			System.out.println("                 1------����˳���                       ");
			System.out.println("                 2------����Ԫ��                        ");
			System.out.println("                 3------ɾ��Ԫ��                        ");
			System.out.println("                 4------��λ�ò���Ԫ��                    ");
			System.out.println("                 5------��ֵ����Ԫ��λ��                  ");
			System.out.println("                 6------˳�����                       ");
			System.out.println("                 0------�˳�                           ");
			System.out.println("======================================================");
			System.out.print("����˵��ţ�");
			number = input.nextInt();
			switch (number) {
			case 1:
				System.out.print("���Ա��Ա������");
				sl.createList(input.nextInt());
				System.out.print("������˳���Ϊ��");
				sl.dispList();
				break;
			case 2:
				System.out.print("���������λ�ú���Ҫ�����Ԫ�أ�");
				sl.insElem(input.nextInt(), input.nextInt());
				System.out.println("\n�����ı�Ϊ��");
				sl.dispList();
				break;
			case 3:
				System.out.print("������ɾ��λ�ã�");
				sl.delElem(input.nextInt(), sl.getX());
				System.out.println("\nɾ����ı�Ϊ��");
				sl.dispList();
				break;
			case 4:
				System.out.print("������λ�ã�");
				int i = input.nextInt();
				sl.getElem(i, sl.getX());
				System.out.println("\n�ڵ�" + i + "λ���ҵ���Ԫ��Ϊ��" + sl.getX());
				break;
			case 5:
				System.out.print("��������Ҫ���ҵ�Ԫ�أ�");
				sl.setX(input.nextInt());
				System.out.println("\n��Ԫ���±�Ϊ��" + sl.locate(sl.getX()));
				break;
			case 6:
				System.out.println("��˳�����Ϊ��" + sl.getLenght());
				break;
			case 0:
				ex = false;
				break;
			default:
				System.out.print("�˵��������������������룺");
			}
			/*
			 * if(number != 0) { System.out.println("\n����������ز˵�������1�˳�");
			 * 
			 * }
			 */
		}
		input.close();
	}

}