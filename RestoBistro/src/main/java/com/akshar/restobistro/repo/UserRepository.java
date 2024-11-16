package com.akshar.restobistro.repo;

import com.akshar.restobistro.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u Set u.email = ?1, u.fullName = ?2, u.updatedAt=?3 where u.email = ?4")
    int updateUserByEmail(@Param("email") String email,
                    @Param("fullName") String fullName,
                    @Param("date") Date date,
                    @Param("oldEmail") String oldEmail);
}
