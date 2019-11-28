package cn.coinque.consumer.system.controller;

import cn.coinque.consumer.system.exception.JsonResult;
import cn.coinque.consumer.system.utils.Audience;
import cn.coinque.consumer.system.utils.JwtHelper;
import cn.conque.api.entity.User;
import cn.conque.api.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author
 */
@RestController
@RequestMapping("/user")
@Api(tags = {"9.0.1"}, description = "用户", value = "用户")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);

    @Reference
    UserService userServiceImpl;
    @Autowired
    private Audience audience;


    @GetMapping("/getUser/{id}")
    @ApiOperation(value = "用户条件查询")
    @ResponseBody
    public JsonResult getUser(@PathVariable Long id) {
        User user=userServiceImpl.getUserById(id);
        JsonResult jsonResult = new JsonResult();
        try {
            if (user != null) {
                jsonResult.putDataValue("user", user);
                jsonResult.success();
                logger.info(new Date()+" 用户条件查询 成功！");
            } else{
                jsonResult.fail();
            }
        } catch (Exception e) {
            jsonResult.setCode(-1);
            logger.error(new Date()+" 用户条件查询 异常！");
            e.printStackTrace();
        }
        return jsonResult;
    }

    /*
    *全局异常测试：
    */
    @RequestMapping("/exce")
    public String showInfo(){
        System.err.println("dddddddddddddd");
        String info ="你好";
        int a = 1/0;
        return info;
    }

    @PostMapping("login")
    @ApiOperation(value = "登录接口")
    public JsonResult login(@RequestParam String name, @RequestParam String pwd, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        User user=userServiceImpl.login(name,pwd);
        if (user == null) {
            return jsonResult.fail();
        }
        String jwtToken = JwtHelper.createJWT(user.getName(),
                user.getId().toString(),
                audience.getClientId(),
                audience.getName(),
                audience.getExpiresSecond()*1000,
                audience.getBase64Secret());
        String token = "bearer;" + jwtToken;
        jsonResult.putDataValue("token", token);
        jsonResult.success();
        return jsonResult;
    }

}
