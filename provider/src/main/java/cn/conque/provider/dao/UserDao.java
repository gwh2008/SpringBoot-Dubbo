package cn.conque.provider.dao;

import org.apache.ibatis.annotations.Param;
import cn.conque.api.entity.User;

/**
 * 接口
 */
public interface UserDao {

    /**
     * 根据用户id获取用户详情
     * @param id user.id
     * @return User
     */
    User getUserById(@Param("id") Long id);

    //登录
    User login(@Param("name")String name, @Param("pwd")String pwd);
}
