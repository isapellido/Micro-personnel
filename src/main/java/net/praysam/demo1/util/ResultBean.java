package net.praysam.demo1.util;

import lombok.Data;

/**
 *  统一返回的对象
 * @param <T>
 */

@Data
public class ResultBean<T> {
    private int code;
    private String message;
    private Object data;

    private ResultBean(){}

    public static <T> ResultBean<T> error(int code , String message){
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        return  resultBean;
    }

    public static <T> ResultBean<T> success(String message){
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage(message);
        return  resultBean;
    }

    public static <T> ResultBean<T> success(Object object){
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("success");
        resultBean.setData(object);
        return  resultBean;
    }

}
