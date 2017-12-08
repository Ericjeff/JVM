package com.imooc.cglib_;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDemo1 {
	public static void main(String[] args) {
		for(int i=0;i<10000;i++){
			test();
		}
	}
	
	private static void test(){
		
		Enhancer e = new Enhancer();
		//将父类的class传入，生成子类
		e.setSuperclass(TemplateClass.class);
		//不使用缓存
		e.setUseCache(false);
		
		e.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("invokeSuper before");
				 Object obj = arg3.invokeSuper(arg0, arg2);
				 System.out.println("invokeSuper after");
				 return obj;
			}
			
		});
		TemplateClass t = (TemplateClass)e.create();
		t.father();
	}
}
