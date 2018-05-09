package com.gl.sdp.pricecoin.bl;

import com.gl.sdp.pricecoin.bl.exceptions.UnauthorizedUserPriceCoinException;
import com.gl.sdp.pricecoin.dl.User;
import com.gl.sdp.pricecoin.dl.UserDao;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User createUser(String name, int limit) {
        User user = new User();
        user.setCounter(0);
        user.setUser(RandomStringUtils.randomAlphanumeric(15));
        user.setName(name);
        user.setUserLimit(limit);
        user = userDao.save(user);
        return user;
    }

    public void checkUser(String user) {
        User userEntity = userDao.findByUser(user);
        if (userEntity == null) {
            throw new UnauthorizedUserPriceCoinException();
        }
    }
}
