package com.stage.upc.randy.pululu.repository;

import com.stage.upc.randy.pululu.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
