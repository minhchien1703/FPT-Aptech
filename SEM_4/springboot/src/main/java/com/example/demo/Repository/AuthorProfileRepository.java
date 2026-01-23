package com.example.demo.Repository;

import com.example.demo.Entity.AuthorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorProfileRepository extends JpaRepository<AuthorProfile, Long> {
}
