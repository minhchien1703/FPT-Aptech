package org.example.mywebservice.model;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Employee {
    private int id;
    private String name;
    private double salary;
}
