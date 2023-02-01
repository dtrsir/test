package com.zhongzheng.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File source = new File("C:\\Users\\zhongzheng\\Desktop\\文件复制\\source");
		File target = new File("C:\\Users\\zhongzheng\\Desktop\\文件复制\\target");
		copy(source, target);
	}
	
	
	public static void copy(File source, File target) throws IOException {
		File[] f = source.listFiles();
		if(!source.exists()) {
			System.out.println("文件路径不存在");
			System.exit(-1);
		}
		String path;
		for (File file2 : f) {
			if(file2.isDirectory()) {
				target = new File("C:\\Users\\zhongzheng\\Desktop\\文件复制\\target"+"\\"+file2.getName());
				target.mkdirs();
				copy(file2, target);
			}else {
				path = target.getAbsolutePath();
				target = new File(target.getAbsolutePath()+"\\"+file2.getName());
				dataCopy(file2, target);
				target = new File(path);
			}
		}
	}
	public static void dataCopy(File source, File target) throws IOException {
		try(FileReader input = new FileReader(source);
		FileWriter output = new FileWriter(target);){
			int flas = 0;
			while((flas=input.read())!=-1) {
				output.write(flas);
			}
		}
	}
}
