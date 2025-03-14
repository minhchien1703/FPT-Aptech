package com.example.demo_spring_boot.controller;

import com.example.demo_spring_boot.entities.ClassRoom;
import com.example.demo_spring_boot.services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/classroom")
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping
    public List<ClassRoom> displayAllClassRooms() {
        return this.classRoomService.getClassRooms();
    }



}
