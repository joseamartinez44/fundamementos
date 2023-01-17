package com.sm.fundamentos.repository;

import com.sm.fundamentos.dto.UserDto;
import com.sm.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("Select u FROM User u WHERE u.name LIKE ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthdayBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdAsc(String name);

    @Query("SELECT new com.sm.fundamentos.dto.UserDto(u.id, u.name, u.birthday) " +
            "FROM User u " +
            "WHERE u.birthday=:parametroFecha " +
            "AND u.email=:parametroEmail")
    Optional<UserDto> getAllBirthdayAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);
}
