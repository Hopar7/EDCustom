package com.ho.edcustom.repository;

import com.ho.edcustom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
