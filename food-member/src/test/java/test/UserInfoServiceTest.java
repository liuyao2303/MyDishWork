package test;

import com.liuyao.constant.UserStatus;
import com.liuyao.dmo.*;
import com.liuyao.dmo.UserInfoDmo;
import com.liuyao.dto.UserInfoDto;
import com.liuyao.dto.UserLoginDto;
import com.liuyao.service.intf.UserInfoService;
import com.liuyao.service.intf.UserLoginService;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/16.
 */
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserLoginService userLoginService;

    public void setUp() {

    }

    public void tearDown() {

    }

    @org.junit.Test
    public void updateUserInfoUserName() {
        int i = userInfoService.updateUserInfoName(12L,"alter name");
         System.out.println(i);
    }


    @org.junit.Test
    public void testAddNewUser() {

        UserInfoDto user = new UserInfoDto();
        user.setAge(12);
        user.setStatus(UserStatus.USER_STATUS_OK);
        user.setUserName("liuyao");
        user.setAddr("江苏省南京市新模范马路66号，南京邮电大学");
        user.setPhoneNumber("18252063065");
        user.setSex("00");
        Long userId = userInfoService.addUserInfo(user);

        UserLoginDto login = new UserLoginDto();
        login.setStatus(UserStatus.USER_STATUS_OK);
        login.setPassword("sdsdsdsd");
        login.setOpenId(245244354343L);
        login.setUserId(userId);
        userLoginService.addUserLoginInfo(login);
    }

    @org.junit.Test
    public void getAllUserInfo() {
        List<UserInfoDto> users = userInfoService.getAllUserInfo();
        for(UserInfoDto dto : users) {
            System.out.println(dto);
        }
    }

}
