package com.example.demo.repository;

import com.example.demo.entity.AuthorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorProfileRepository extends JpaRepository<AuthorProfile, Long> {
}
