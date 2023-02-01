package com.zhongzheng.����;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test01 {
	//���Ͳ���
	public void test01(Map<String, Integer> map, List<Integer> list) {
		 System.out.println("test1");
	 }
	 //���ͷ���ֵ
	public List<Integer> test02(){
		System.out.println("test02");
		return null;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//ͨ�������ȡ��test01�������
		Method method = Test01.class.getMethod("test01", Map.class, List.class);
		//�������Ĳ����б������
		Type[] GenericParametherTypes  = method.getGenericParameterTypes();
		//���ʱ�������Ѿ��õ���test01��������ķ��Ͳ�����
		//��һ�������ǿ����õ����Ͳ���������
		//���������б�
		for (Type type : GenericParametherTypes) {
			if(type instanceof ParameterizedType) {
				//�������Ǿ��õ��˷��Ͳ�����������
			 	Type[] act = ((ParameterizedType)type).getActualTypeArguments();
			}
		}
		
		/*
		 *ͨ�������õ����ͷ���ֵ  
		 */
		
		//ͨ�������ȡ��test02�������
		Method method2 = Test01.class.getMethod("test02", Map.class, List.class);
		//�������ķ���ֵ���ʹ�����
		Type genericReturnType  = method.getGenericReturnType();
		//���ʱ�������Ѿ��õ���test02��������ķ��ͷ���ֵ��
		//ͬ������Ҳ�����õ����ͷ���ֵ������
		if(genericReturnType instanceof ParameterizedType) {
			//���������õ��˷��ͷ���ֵ��������
		 	Type[] act = ((ParameterizedType)genericReturnType).getActualTypeArguments();
		}
	}
}

