package com.example.demo_spring_boot.services;


import com.example.demo_spring_boot.entities.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> getClassRooms();
}
