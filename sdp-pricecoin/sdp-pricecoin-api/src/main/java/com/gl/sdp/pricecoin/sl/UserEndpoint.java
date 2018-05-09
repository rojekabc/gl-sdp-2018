package com.gl.sdp.pricecoin.sl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserEndpoint {
    static final String BASE_PATH = "/api/v1/user";

    @RequestMapping(
            path = BASE_PATH,
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserInfoSO appendUser(
            @RequestBody UserCreateSO request
    );

    @RequestMapping(
            path = BASE_PATH + "/{user}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserInfoSO getUserInfo(
            @PathVariable(name = "user") String user);


    @RequestMapping(
            path = BASE_PATH + "/{user}",
            method = RequestMethod.DELETE
    )
    void removeUser(
            @PathVariable(name = "user") String user);

    @RequestMapping(
            path = BASE_PATH + "/{user}/limit",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserInfoSO getUserLimit(
            @PathVariable(name = "user") String user);

    @RequestMapping(
            path = BASE_PATH + "/{user}/limit",
            method = RequestMethod.DELETE
    )
    void removeUserLimit(
            @PathVariable(name = "user") String user);

    @RequestMapping(
            path = BASE_PATH + "/{user}/limit/{limit}",
            method = RequestMethod.PUT
    )
    void setUserLimit(
            @PathVariable(name = "user") String user,
            @PathVariable(name = "limit") int limit);
}
