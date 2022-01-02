package com.scube.Springboot_CRUD_app.repository;


import com.scube.Springboot_CRUD_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
