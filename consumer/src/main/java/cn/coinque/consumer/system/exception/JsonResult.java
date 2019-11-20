package cn.coinque.consumer.system.exception;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * lombok格式化数据
 */
@Data
public class JsonResult implements Serializable {

    private int code;   //返回码 非0即失败
    private String msg; //消息提示
    private Map<String, Object> data  = new ConcurrentHashMap(); //返回的数据

    public JsonResult(){};

    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public JsonResult(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }
    public JsonResult success() {
        this.code = 0;
        this.msg = "Success";
        return this;
    }
    public JsonResult fail() {
        this.code = -1;
        this.msg = "查询数据为空！";
        return this;
    }
    public static String success(Map<String, Object> data) {
        return JSON.toJSONString(new JsonResult(0, "解析成功", data));
    }

    public static String failed() {
        return failed("解析失败");
    }
    public static String failed(String msg) {
        return failed(-1, msg);
    }
    public static String failed(int code, String msg) {
        return JSON.toJSONString(new JsonResult(code, msg, new HashMap(0)));
    }

}