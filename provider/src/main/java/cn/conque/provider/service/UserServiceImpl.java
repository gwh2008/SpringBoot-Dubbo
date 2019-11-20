package cn.conque.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.conque.api.entity.User;
import cn.conque.api.service.UserService;
import cn.conque.provider.dao.UserDao;

/**
 * ServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(Long id) {
        User user = userDao.getUserById(id);
        System.err.println(user);
        return user;
    }
}
