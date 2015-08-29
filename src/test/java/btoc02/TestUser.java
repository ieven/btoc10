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
}
