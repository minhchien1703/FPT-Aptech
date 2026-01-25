package com.example.demo.service.impl;

import com.example.demo.entity.AuthorProfile;
import com.example.demo.repository.AuthorProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorProfileServiceImpl {
    @Autowired
    private AuthorProfileRepository profileRepository;

//    @Override
    @Transactional
    public AuthorProfile updateProfile(Long id, AuthorProfile profile) {
        AuthorProfile existing = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Profile!"));
        existing.setBio(profile.getBio());
        existing.setWebsite(profile.getWebsite());
        return profileRepository.save(existing);
    }
}
