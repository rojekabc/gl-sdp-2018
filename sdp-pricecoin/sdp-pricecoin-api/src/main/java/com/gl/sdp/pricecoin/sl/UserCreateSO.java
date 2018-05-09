package com.gl.sdp.pricecoin.sl;

import java.io.Serializable;

public class UserCreateSO implements Serializable {
    private String userName;
    private int userLimit;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(int userLimit) {
        this.userLimit = userLimit;
    }
}
