package com.demo.mysql_resources.monitor;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * @author 宋艾衡
 * @date 2019/6/24 14:55
 * @desc
 */
public class DruidStatViewServlet extends StatViewServlet {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    @Override
    public String getInitParameter(String name) {
        if ("loginUsername".equals(name)) {
            return username;
        }

        if ("loginPassword".equals(name)) {
            return password;
        }

        return super.getInitParameter(name);
    }

    public DruidStatViewServlet(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
