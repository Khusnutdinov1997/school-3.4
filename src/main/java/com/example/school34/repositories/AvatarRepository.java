package com.example.school34.repositories;

import com.example.school34.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository <Avatar, Long> {

    Optional<Avatar> findByStudentId (Long studentId);

}
