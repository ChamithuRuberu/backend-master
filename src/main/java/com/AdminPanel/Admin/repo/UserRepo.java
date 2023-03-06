package com.AdminPanel.Admin.repo;
import com.AdminPanel.Admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    List<User> findAllByUserNameEquals(String username);
    Optional<User> findByUserNicEquals(String nic);
}
