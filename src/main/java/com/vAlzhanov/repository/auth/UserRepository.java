package com.vAlzhanov.repository.auth;

import java.util.Optional;
import java.util.Set;

import com.vAlzhanov.models.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Set<User> findAllByMessagesIsNotNull();

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
