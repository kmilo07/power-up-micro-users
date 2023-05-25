package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByDniNumber(String dniNumber);
    Optional<UserEntity> findByEmail(String email);
    void deleteById(Long userId);

    @Query(value = "" +
            "SELECT r.name FROM user u, role r " +
            "WHERE  u.id_role = r.id AND " +
            "       u.id = :userId", nativeQuery = true)
    Optional<String> getRoleByUserId(@Param("userId") Long userId);

    @Query(value = "" +
            "SELECT id  FROM user " +
            "WHERE  email = :email",nativeQuery = true)
    Optional<Long> getUserIdByEmail(@Param("email") String email);
}
