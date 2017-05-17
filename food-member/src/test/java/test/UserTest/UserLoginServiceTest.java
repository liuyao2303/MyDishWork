package test.UserTest;

import com.ccq.framework.lang.Result;
import com.liuyao.dto.UserLoginDto;
import com.liuyao.service.intf.UserLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaoliu on 2017/5/16.
 */
@ContextConfiguration(locations = "classpath:application-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserLoginServiceTest {

    @Autowired
    private UserLoginService userLoginService;

    @org.junit.Test
    public void getUserLoginInfo() {
        UserLoginDto dto = userLoginService.getUserLoginInfo(7L);
        System.out.println(dto);
    }

    @Test
    public void userLogin() {
        Result r = userLoginService.loginCheck("18252063065","sdsdsdsd");
        System.out.println(r);
    }

    @Test
    public void testPwdAlter() {
        Result r = userLoginService.alterPassword("liuyao","hello world");
        System.out.println(r);
    }
}
