package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
        private String username;
        private String password;

    public String execute() {
        ActionContext context = ActionContext.getContext();
        if ("郭怀江".equals(username) && "123456".equals(password)) {
            context.put("username", username);
            context.put("password", password);
            context.put("success", "用户登录成功！");
            return SUCCESS;
        } else {
            context.put("error", "用户登录失败！");
            return ERROR;
        }
    }
}
