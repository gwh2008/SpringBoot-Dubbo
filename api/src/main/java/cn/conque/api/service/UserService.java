package cn.conque.api.service;
import cn.conque.api.entity.User;

/**
 * @author
 */
public interface UserService {

    /** 根据id获取用户信息
     * @param id
     * @return User
     */
    User getUserById(Long id);

    User login(String name,String pwd);
}
