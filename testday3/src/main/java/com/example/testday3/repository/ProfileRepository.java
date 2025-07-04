package com.example.testday3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testday3.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
