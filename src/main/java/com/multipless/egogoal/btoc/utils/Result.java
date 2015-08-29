package com.multipless.egogoal.btoc.utils;

/**
 * @author ChenKai
 * @date 2015年8月29日
 */
public class Result {
	//错误代码：1:表示成功，0:表示错误
	private int resCode; 
	private String msg;
	private Object data;
	
	public Result(int resCode,String msg,Object data){
		this.resCode = resCode;
		this.msg = msg;
		this.data = data;
	}
	
	
	public static Result success(Object data){
		Result result=new Result(1,"success",data);
		return result;
	}
	
	public static Result error(String msg){
		Result result=new Result(0,msg,null);
		return result;
	}
	
	public int getResCode() {
		return resCode;
	}
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Result [resCode=" + resCode + ", msg=" + msg + ", data=" + data + "]";
	}
}
