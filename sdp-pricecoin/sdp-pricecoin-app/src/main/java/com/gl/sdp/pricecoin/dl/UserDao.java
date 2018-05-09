package com.gl.sdp.pricecoin.dl;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
    User findByUser(String user);
}
