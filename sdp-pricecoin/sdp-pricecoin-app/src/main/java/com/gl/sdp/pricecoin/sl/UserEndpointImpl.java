package com.gl.sdp.pricecoin.sl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class UserEndpointImpl implements UserEndpoint {
    public UserInfoSO appendUser(
            @RequestBody UserCreateSO request) {
        return null;
    }

    public UserInfoSO getUserInfo(
            @PathVariable(name = "user") String user) {
        return null;
    }


    public void removeUser(
            @PathVariable(name = "user") String user) {

    }

    public UserInfoSO getUserLimit(
            @PathVariable(name = "user") String user) {
        return null;
    }

    public void removeUserLimit(
            @PathVariable(name = "user") String user) {

    }

    public void setUserLimit(
            @PathVariable(name = "user") String user,
            @PathVariable(name = "limit") int limit) {

    }
}
