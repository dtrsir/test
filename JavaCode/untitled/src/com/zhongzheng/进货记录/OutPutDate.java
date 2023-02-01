package com.zhongzheng.进货记录;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class OutPutDate {
	
	public OutPutDate()  {
		super();
		// TODO Auto-generated constructor stub
		
	}

	public <LocalDated> void outPutDate(int serialNumber, String name, String peopleName, double maney, int buyNumber) throws IOException {
		int total = (int) (maney * buyNumber);
		LocalDated localDate = (LocalDated) LocalDate.now();
		File f = new File("./"+localDate+".cvs");
		if(f.exists()) {
			try(FileWriter fw = new FileWriter(f,true);){
				fw.write(serialNumber+","+name+","+buyNumber+","+maney+","+total+","+peopleName+'\n');
				fw.flush();
			}
		}else {
			try(FileWriter fw = new FileWriter(f,false);){
				fw.write("商品编号"+","+"商品名称"+","+"购买数量"+","+"单价"+","+"总价"+","+"联系人"+'\n');
				fw.write(serialNumber+","+name+","+buyNumber+","+maney+","+total+","+peopleName+'\n');
				fw.flush();
			}
		}
		
		
	}

}
