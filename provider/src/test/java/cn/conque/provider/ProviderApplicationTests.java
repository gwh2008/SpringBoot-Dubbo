package cn.conque.provider;


import cn.conque.provider.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.conque.api.entity.User;
import cn.conque.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("cn.conque.provider.dao")
public class ProviderApplicationTests {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        User user = userDao.getUserById(1L);
        System.err.println(user.toString());
    }
    @Test
    public void test(){
        User user= userService.getUserById(2L);
        System.err.println(user.toString());
    }

}
