package com.AdminPanel.Admin.repo;

import com.AdminPanel.Admin.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Repository
@EnableJpaRepositories
public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
