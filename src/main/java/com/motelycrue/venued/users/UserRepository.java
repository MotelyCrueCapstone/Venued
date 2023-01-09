package com.motelycrue.venued.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);

    User findByUsername(String userName);

}
