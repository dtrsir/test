package com.zhongzheng.XX;

public abstract class GenericMatrix<E extends Complex>{
	public abstract E add(E o1, E o2);
	public abstract E mutiple(E o1, E o2);
	public abstract E zero();
	
	public E[][] addMatrix(E[][] c1 ,E[][] c2){
		E[][] list = (E[][])new Complex[Math.max(c1.length, c2.length)][Math.max(c1[0].length, c2[0].length)];
		for(int i = 0;i<c1.length;i++) {
			for(int j = 0;j<c1[i].length;j++) {
				list[i][j] = add(c1[i][j], c2[i][j]);
			}
		}
		return list;
	}
	
	public E[][] mutipleMatrix(E[][] c1 ,E[][] c2){
		E[][] list = (E[][])new Complex[c1[0].length][c2.length];
		for(int i = 0;i<c1.length;i++) {
			for(int j = 0;j<c1[i].length;j++) {
				list[i][j]=(E) new Complex();
				for(int count = 0;count<c1[0].length;count++) {
					list[i][j] = add((E)list[i][j], mutiple(c1[i][count], c2[count][i]));
				}
				
			}
		}
		return list;
	}
	
	
}
