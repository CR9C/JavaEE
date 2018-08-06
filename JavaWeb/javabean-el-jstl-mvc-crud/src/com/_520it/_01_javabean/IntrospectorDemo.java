package com._520it._01_javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
//获取User的属性
public class IntrospectorDemo {
	public static void main(String[] args) throws Exception {
		//BeanInfo getBeanInfo(Class<?> beanClass, Class<?> stopClass): 获取哪一份字节码的JavaBean描述对象 
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);
		//PropertyDescriptor[] getPropertyDescriptors():获取描述JavaBean所有属性的描述器
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			String name = pd.getName();//属性名称
			Class type = pd.getPropertyType();//属性类型
			Method getter = pd.getReadMethod();//获取getter方法
			Method setter = pd.getWriteMethod();//获取setter方法
			System.out.println(name + "," +type);
			System.out.println(getter);
			System.out.println(setter);
			if (getter != null) {
				System.out.println(getter.invoke(new User()));
			}
			System.out.println("------------------------------------");
		}
	}
}
