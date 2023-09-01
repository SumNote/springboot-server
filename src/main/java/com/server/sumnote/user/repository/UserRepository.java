package com.server.sumnote.user.repository;

import com.server.sumnote.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
    void deleteUserByEmail(String email);

}
