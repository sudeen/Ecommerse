package com.sudin.security.springsecurityauthserver.repository;

import com.sudin.security.springsecurityauthserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
