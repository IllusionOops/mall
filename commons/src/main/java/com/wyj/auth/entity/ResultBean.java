package com.wyj.auth.entity;

import java.io.Serializable;

/**
 * @author wuyijie
 * @project irrigate
 * @className ResultBean
 * @description TODO
 * @date 2020/8/11 13:18
 */


public class ResultBean implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public ResultBean(){}

    public ResultBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultBean returnInsertSuccess(Object data) {
        return new ResultBean(ResultCodeAndMsgEnum.SUCCESS_ADD.code, ResultCodeAndMsgEnum.SUCCESS_ADD.msg, data);
    }

    public static ResultBean returnInsertUnSuccess(Object data) {
        return new ResultBean(ResultCodeAndMsgEnum.ERROR_ADD.code, ResultCodeAndMsgEnum.ERROR_ADD.getMsg(), data);
    }

    public static ResultBean returnDeleteSuccess(Object data) {
        return new ResultBean(ResultCodeAndMsgEnum.SUCCESS_DELETE.code, ResultCodeAndMsgEnum.SUCCESS_DELETE.getMsg(), data);
    }

    public static ResultBean returnDeleteUnSuccess(Object data) {
        return new ResultBean(ResultCodeAndMsgEnum.ERROR_DELETE.getCode(), ResultCodeAndMsgEnum.ERROR_DELETE.getMsg(), data);
    }

    public static ResultBean returnUpdateSuccess(Object data) {
        return new ResultBean(ResultCodeAndMsgEnum.SUCCESS_EDIT.getCode(), ResultCodeAndMsgEnum.SUCCESS_EDIT.getMsg(), data);
    }

    public static ResultBean returnUpdateUnSuccess(Object data) {
        return new ResultBean(ResultCodeAndMsgEnum.ERROR_EDIT.getCode(), ResultCodeAndMsgEnum.ERROR_EDIT.getMsg(), data);
    }

    public static ResultBean returnSelectSuccess(Object data) {
        return new ResultBean(ResultCodeAndMsgEnum.SUCCESS_QUERY.getCode(), ResultCodeAndMsgEnum.SUCCESS_QUERY.getMsg(), data);
    }

    public static ResultBean returnSelectUnSuccess(Object data) {
        return new ResultBean(ResultCodeAndMsgEnum.ERROR_QUERY.getCode(), ResultCodeAndMsgEnum.ERROR_QUERY.getMsg(), data);
    }

}