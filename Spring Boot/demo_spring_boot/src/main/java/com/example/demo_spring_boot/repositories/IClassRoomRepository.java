package com.example.demo_spring_boot.repositories;

import com.example.demo_spring_boot.entities.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRoomRepository extends JpaRepository<ClassRoom, Long> {

}
