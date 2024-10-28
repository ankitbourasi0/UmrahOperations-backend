package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.LoginPrev;
import com.umrahoperations.UmrahOperations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<LoginPrev, Long> {


        @Query(value = "SELECT * FROM LoginPrevs", nativeQuery = true)
        List<LoginPrev> findAllUsers();

        //Find By Email
        @Query(value = "SELECT * FROM LoginPrevs WHERE USER_LOGIN = :emailId", nativeQuery = true)
        List<User> findUserByEmailNative(@Param("emailId") String emailId);

}
