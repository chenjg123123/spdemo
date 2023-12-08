package spring.review.demo.sys.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回通用结果，服务端相应的数据
 */
@Data
public class Result<T> {
    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

//    private T data; //数据

    private Map data = new HashMap(); //动态数据

    public static <T> Result<T> success(String key,Object object) {
        Result<T> result = new Result<T>();
        result.data.put(key,object);
        result.code = 1;

        return result;
    }

    public static <T> Result<T> success(String key, Object object, String msg) {
        Result<T> result = new Result<>();
        result.data.put(key, object);
        result.code = 1;
        result.msg = msg;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

    public Result<T> add(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
    public static <T> Result<T> login(){
        Result result = new Result();
        result.code = 402;
        result.msg = "登陆过期";
        return result;
    }
}
