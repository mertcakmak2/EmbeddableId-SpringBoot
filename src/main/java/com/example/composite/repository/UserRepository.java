package com.example.composite.repository;

import com.example.composite.embeddableIds.UserEmbeddedId;
import com.example.composite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UserEmbeddedId> {
}
