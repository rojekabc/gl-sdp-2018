package com.gl.sdp.pricecoin.bl;

import com.gl.sdp.pricecoin.bl.exceptions.QuotaUserPriceCoinException;
import com.gl.sdp.pricecoin.bl.exceptions.UnauthorizedUserPriceCoinException;
import com.gl.sdp.pricecoin.dl.User;
import com.gl.sdp.pricecoin.dl.UserDao;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Transactional
    public void checkUser(String user) {
        User userEntity = userDao.findByUser(user);
        if (userEntity == null) {
            throw new UnauthorizedUserPriceCoinException();
        }
        int counter = userEntity.getCounter();
        int userLimit = userEntity.getUserLimit();
        if ( counter >= userLimit ) {
            throw new QuotaUserPriceCoinException();
        }
        counter++;
        userEntity.setCounter(counter);
    }
}
