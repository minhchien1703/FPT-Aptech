package com.example.demo_spring_boot.services;

import com.example.demo_spring_boot.entities.ClassRoom;
import com.example.demo_spring_boot.repositories.IClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {

    private IClassRoomRepository classRoomRepository;

    @Autowired
    public ClassRoomService(IClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public List<ClassRoom> getClassRooms() {
        return this.classRoomRepository.findAll();
    }

}
