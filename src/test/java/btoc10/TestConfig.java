package btoc10;

import com.multipless.egogoal.btoc.utils.PropsLoader;

/**
 * @author ChenKai
 * @date 2015年8月31日
 */
public class TestConfig {

	public static void main(String[] args) {
		String value = PropsLoader.getString("saohuobang.micromall.url");
		System.out.println(value);
	}

}
