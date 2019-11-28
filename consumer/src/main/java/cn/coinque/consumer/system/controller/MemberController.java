package cn.coinque.consumer.system.controller;

import cn.coinque.consumer.system.exception.JsonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2018/9/29.
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @RequestMapping(value = "i/e/{data}",method = RequestMethod.GET)
    public JsonResult execute(@PathVariable String data){
        JsonResult jsonResult = new JsonResult();
        jsonResult.putDataValue("member", data);
        jsonResult.success();
        return jsonResult;
    }
}
