package com.gourmetx.GourmetX.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gourmetx.GourmetX.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}