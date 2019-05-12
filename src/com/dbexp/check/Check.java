package com.dbexp.check;

/**
 * @Author: Steph
 * @Date: 2019/5/12
 */
public class Check {
    public static boolean checkreturn(String account, String password) {
        boolean pass = false;
        if (account.equals("system") && password.equals("123456")) {
            pass = true;
        }
        return pass;
    }
}
