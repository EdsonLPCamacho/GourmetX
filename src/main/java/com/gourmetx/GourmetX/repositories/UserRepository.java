package com.gourmetx.GourmetX.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gourmetx.GourmetX.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // Método usando consulta personalizada
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    Optional<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
