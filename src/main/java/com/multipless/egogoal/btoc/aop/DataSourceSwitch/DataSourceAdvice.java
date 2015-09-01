package com.multipless.egogoal.btoc.aop.DataSourceSwitch;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

/**
 * @author ChenKai
 * @date 2015年9月1日
 */
public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice{
	private String[] methodPrefix;

	/**
	 *如果方法名是以"add","insert","change","validate","cancel","create","save","edit","update","delete","remove","invoke"开头，则切换到主库，否则为从库
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("point:" + target.getClass().getName()+"class"+method.getName()+"method");
		int i = 0;
		boolean flag = false;
		while(i < this.methodPrefix.length - 1){
			flag = (flag) || (method.getName().startsWith(this.methodPrefix[i]))||(method.getName().startsWith(this.methodPrefix[(i+1)]));
			i++;
		}
		if(flag){
			System.out.println("switch to master");
			DataSourceSwitcher.setMaster();
		}else{
			System.out.println("switch to slaver");
			DataSourceSwitcher.setSlave();
		}
	}

	@Override
	public void afterReturning(Object arg0, Method method, Object[] args, Object target) throws Throwable {
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
		DataSourceSwitcher.setMaster();
		System.out.println("finde exception, switch to master");
	}
	

	public String[] getMethodPrefix() {
		return this.methodPrefix;
	}

	public void setMethodPrefix(String[] methodPrefix) {
		this.methodPrefix = methodPrefix;
	}
	
	
public static void main(String[] args) {
	String[] methodPrefix = {"add","insert","change","validate","cancel","create","save","edit","update","delete","remove","invoke"};
	String methodName = "createUser";
	int i = 0;
	while(i <methodPrefix.length-1){
		boolean flag = methodName.startsWith(methodPrefix[i]);
		System.out.println(flag);
		i++;
	}
}
}
