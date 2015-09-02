package com.multipless.egogoal.btoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.multipless.egogoal.btoc.entity.UserEntity;
import com.multipless.egogoal.btoc.service.UserService;
import com.multipless.egogoal.btoc.utils.Result;

/**
 * @author ChenKai
 * @date 2015年8月28日
 */

@Controller
@RequestMapping("/btoc/front/user")
@SessionAttributes({"userId","userName"})
public class UserController {
	private static final Logger LOG = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	//http://localhost:8080/btoc01/btoc/front/user/list1.json
	/**
	 * 列表页1，无参数传递,返回Json格式
	 */
	@ResponseBody
	@RequestMapping(value = "list1")
	public Result list1() {
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		LOG.info("haha");
		return Result.success(list);
		//{"resCode":1,"msg":"success","data":["111","222","333","444"]}
	}
	
	/**
	 * 列表页2，无参数传递
	 */
	@ResponseBody
	@RequestMapping(value = "list2")
	public List<String> list2() {
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		return list;
		//["111","222","333","444"]
	}

	
	
	/**
	 *列表页3，返回webapp/btoc/userList.jsp页面
	 */
	@RequestMapping(value = "list3")
	public ModelAndView list3(ModelMap model) {
		model.put("userId", 111);
		model.put("userName", "multiplsess");
		return new ModelAndView("userList", model);
	}
	
	/**
	 *列表页4，重定向到百度
	 */
	@RequestMapping(value = "list4")
	public ModelAndView list4(ModelMap model) {
		return new ModelAndView("redirect:http://baidu.com", model);
	}
	
	/**
	 *列表页5，使用EL表达式在jsp页面显示内容。request级别的
	 */
	
	@RequestMapping(value = "list5")
	public String list5(ModelMap model) {
		model.addAttribute("userId","111");
		model.addAttribute("userName","mutiptless");
		return "showVariable1";
	}
	
	/**
	 *列表页6，使用EL表达式在jsp页面显示内容。
	 *在类级别上使用@SessionAttributes({"userId","userName"})，将属性userId,userName都放到session中
	 */
	@RequestMapping(value = "list6")
	public String list6(ModelMap model) {
		model.addAttribute("userId","222");
		model.addAttribute("userName","lei");
		return "showVariable2";
	}
	
	@ResponseBody
	@RequestMapping(value = "list7")
	public Result list7(ModelMap model) {
		List<UserEntity> allUsers = userService.getAllUsers();
		return Result.success(allUsers);
	}
	
	@ResponseBody
	@RequestMapping(value = "list8")
	public Result list8(ModelMap model) {
		UserEntity user = new UserEntity();
		user.setUserId("1620150727200953081403658");
		user.setScoreType("1");
		user.setUserMobile("15321870005");
		Integer status = userService.updateUserByUserId(user);
		return Result.success(status);
	}
	
	
	
	/**
	 *启动项目后，访问http://localhost:8089/btoc10/btoc/front/user/list8.json和list9.json。可以看到控制台输出切换数据库的日志
	 */
	@ResponseBody
	@RequestMapping(value = "list9")
	public Result list9(ModelMap model) {
		String userId = "1620150727200953081403658";
		UserEntity userEntity = userService.selectByPrimaryKey(userId);
		return Result.success(userEntity);
	}
}
