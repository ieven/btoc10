package btoc02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.multipless.egogoal.btoc.entity.UserEntity;
import com.multipless.egogoal.btoc.service.UserService;

/**
 * @author ChenKai
 * @date 2015年8月29日
 * 需要在pom.xml中引用spring-test的jar包才能使用下面的注解
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class TestUser {

	@Autowired
	private UserService userService;
	@Test
	public void testlist(){
		List<UserEntity> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
	}
	
//	@Test
	public void testget(){
		String userId = "1620150616190638980525750";
		UserEntity user = userService.selectByPrimaryKey(userId);
		System.out.println(user);
	}
	
	/**
	 *测试updateUserByUserId整个方法的事务控制
	 */
//	@Test
	public void testupdate(){
		String userId = "1620150616190638980525750";
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userId);
		userEntity.setChannel("3");
		Integer status = userService.updateUserByUserId(userEntity);
		System.out.println(status);
	}
}
