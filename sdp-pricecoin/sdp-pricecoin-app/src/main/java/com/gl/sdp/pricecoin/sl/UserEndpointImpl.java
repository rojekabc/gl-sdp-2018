package com.gl.sdp.pricecoin.sl;

import com.gl.sdp.pricecoin.bl.UserService;
import com.gl.sdp.pricecoin.dl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class UserEndpointImpl implements UserEndpoint {
    @Autowired
    private UserService userService;

    @Autowired
    private DataNeutralizerComponent neutralizer;

    @Autowired
    private DataConverterComponent converter;

    public UserInfoSO appendUser(
            @RequestBody UserCreateSO request) {
        User user = userService.createUser(
                neutralizer.neutralize(request.getUserName()),
                request.getUserLimit());
        return converter.convert(user);
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
