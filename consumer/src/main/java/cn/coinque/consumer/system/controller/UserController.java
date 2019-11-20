package cn.coinque.consumer.system.controller;

import cn.coinque.consumer.system.exception.JsonResult;
import cn.conque.api.entity.User;
import cn.conque.api.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

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

}
