package com.huido.fangassist.repository;

import com.huido.fangassist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByUserName(String userName);
}

