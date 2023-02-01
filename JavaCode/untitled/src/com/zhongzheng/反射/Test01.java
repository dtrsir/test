package com.zhongzheng.反射;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test01 {
	//泛型参数
	public void test01(Map<String, Integer> map, List<Integer> list) {
		 System.out.println("test1");
	 }
	 //泛型返回值
	public List<Integer> test02(){
		System.out.println("test02");
		return null;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//通过反射获取到test01这个方法
		Method method = Test01.class.getMethod("test01", Map.class, List.class);
		//将方法的参数列表存起来
		Type[] GenericParametherTypes  = method.getGenericParameterTypes();
		//这个时候我们已经拿到了test01这个方法的泛型参数了
		//下一步，我们可以拿到泛型参数的类型
		//遍历参数列表
		for (Type type : GenericParametherTypes) {
			if(type instanceof ParameterizedType) {
				//到此我们就拿到了泛型参数的类型了
			 	Type[] act = ((ParameterizedType)type).getActualTypeArguments();
			}
		}
		
		/*
		 *通过反射拿到泛型返回值  
		 */
		
		//通过反射获取到test02这个方法
		Method method2 = Test01.class.getMethod("test02", Map.class, List.class);
		//将方法的返回值类型存起来
		Type genericReturnType  = method.getGenericReturnType();
		//这个时候我们已经拿到了test02这个方法的泛型返回值了
		//同理，我们也可以拿到泛型返回值的类型
		if(genericReturnType instanceof ParameterizedType) {
			//到此我们拿到了泛型返回值的类型了
		 	Type[] act = ((ParameterizedType)genericReturnType).getActualTypeArguments();
		}
	}
}

