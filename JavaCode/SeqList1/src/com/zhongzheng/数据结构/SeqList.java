package com.zhongzheng.数据结构;

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

	/* 初始化顺序表 */
	public void InitList() {
		this.setLenght(0);
	}

	/* 建立顺序表 */
	public void createList(int n) {
		System.out.print("请输入" + n + "个整数：");
		int[] date = new int[n];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			date[i] = input.nextInt();
		}
//		input.close();
		this.setDate(date);
		this.setLenght(n);
	}

	/* 查找操作 */
	public int getElem(int i, int x) {
		if (i < 1 || i > this.getLenght()) {
			System.out.println("查找位置出错");
			return 0;
		} else {
			x = this.getDate()[i - 1];
			return 1;
		}
	}

	/* 查找下标 */
	public int locate(int x) {
		for (int i = 0; i < this.getLenght(); i++) {
			if (this.getDate()[i] == x) {
				return i - 1;
			} else {
				System.out.println("查无此元素");
				return 0;
			}
		}
		return 0;
	}

	/* 插入元素 */
	public int insElem(int i, int x) {
		if (this.getLenght() >= 10) {
			System.out.println("顺序表满，插入失败");
			return 0;
		}
		if (i - 1 >= this.getLenght()) {
			System.out.println("插入位置出错");
			return 0;
		}
		if (i - 1 == this.getLenght()) {
			this.getDate()[i - 1] = x;
			System.out.println("在表尾插入");
			return 1;
		}
		for (int j = this.getLenght(); j > i - 1; j--) {
			this.getDate()[j - 1] = this.getDate()[j];
		}
		this.getDate()[i - 1] = x;
		this.setLenght(this.getLenght() + 1);
		System.out.println("表中插入成功");
		return 1;
	}

	/* 删除元素 */
	public int delElem(int i, Integer x) {
		if (this.getLenght() == 0) {
			System.out.println("表为空，无法删除");
			return 0;
		}
		if (i < 1 || i - 1 > this.getLenght()) {
			System.out.println("删除位置出错");
			return 0;
		}
		x = this.getDate()[i - 1];
		for (int j = i; j <= this.getLenght(); j++) {
			this.getDate()[j - 1] = this.getDate()[j];
		}
		this.setLenght(this.getLenght() - 1);
		System.out.println("删除成功");
		return 1;
	}

	/* 输出元素 */
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
			System.out.println("                 1------建立顺序表                       ");
			System.out.println("                 2------插入元素                        ");
			System.out.println("                 3------删除元素                        ");
			System.out.println("                 4------按位置查找元素                    ");
			System.out.println("                 5------按值查找元素位置                  ");
			System.out.println("                 6------顺序表长度                       ");
			System.out.println("                 0------退出                           ");
			System.out.println("======================================================");
			System.out.print("输入菜单号：");
			number = input.nextInt();
			switch (number) {
			case 1:
				System.out.print("线性表成员个数：");
				sl.createList(input.nextInt());
				System.out.print("创建的顺序表为：");
				sl.dispList();
				break;
			case 2:
				System.out.print("请输入插入位置和需要插入的元素：");
				sl.insElem(input.nextInt(), input.nextInt());
				System.out.println("\n插入后的表为：");
				sl.dispList();
				break;
			case 3:
				System.out.print("请输入删除位置：");
				sl.delElem(input.nextInt(), sl.getX());
				System.out.println("\n删除后的表为：");
				sl.dispList();
				break;
			case 4:
				System.out.print("请输入位置：");
				int i = input.nextInt();
				sl.getElem(i, sl.getX());
				System.out.println("\n在第" + i + "位查找到的元素为：" + sl.getX());
				break;
			case 5:
				System.out.print("请输入需要查找的元素：");
				sl.setX(input.nextInt());
				System.out.println("\n该元素下标为：" + sl.locate(sl.getX()));
				break;
			case 6:
				System.out.println("该顺序表长度为：" + sl.getLenght());
				break;
			case 0:
				ex = false;
				break;
			default:
				System.out.print("菜单号输入有误，请重新输入：");
			}
			/*
			 * if(number != 0) { System.out.println("\n按任意键返回菜单，输入1退出");
			 * 
			 * }
			 */
		}
		input.close();
	}

}