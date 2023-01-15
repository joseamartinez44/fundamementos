package com.sm.fundamentos.repository;

import com.sm.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("Select u FROM User u WHERE u.name LIKE ?1%")
    List<User> findAndSort(String name, Sort sort);
}
