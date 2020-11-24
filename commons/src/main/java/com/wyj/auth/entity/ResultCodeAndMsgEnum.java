package com.wyj.auth.entity;

/**
 * @author wuyijie
 * @project irrigate
 * @className ResultCodeAndMsgEnum
 * @description TODO
 * @date 2020/8/11 13:31
 */

public enum ResultCodeAndMsgEnum {
    /**
     *
     * */
    SUCCESS_ADD(200, "添加成功"),
    /**
     *
     * */
    SUCCESS_DELETE(200, "删除成功"),
    /**
     *
     * */
    SUCCESS_EDIT(200, "修改成功"),
    /**
     *
     * */
    SUCCESS_QUERY(200, "查询成功"),
    /**
     *
     * */
    ERROR_ADD(500, "添加失败"),
    /**
     *
     * */
    ERROR_DELETE(500, "删除失败"),
    /**
     *
     * */
    ERROR_EDIT(500, "修改失败"),
    /**
     *
     * */
    ERROR_QUERY(500, "查询失败"),

    NO_PERSSIOM(403,"没有权限请求"),
    WRONG_ACCOUNT_OR_PSW(403,"账号或密码错误"),
    NO_LOGIN(401,"用户未登录");

    public int code;
    public String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCodeAndMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
