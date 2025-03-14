package com.example.demo_spring_boot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_Class;

    @Column(nullable = false)
    String name_Class;

    @Column(nullable = false)
    int amount;

    public ClassRoom() {}

    public ClassRoom(int id_Class, String name_Class, int amount) {
        this.id_Class = id_Class;
        this.name_Class = name_Class;
        this.amount = amount;
    }

    public int getId_Class() {
        return id_Class;
    }

    public void setId_Class(int id_Class) {
        this.id_Class = id_Class;
    }

    public String getName_Class() {
        return name_Class;
    }

    public void setName_Class(String name_Class) {
        this.name_Class = name_Class;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
