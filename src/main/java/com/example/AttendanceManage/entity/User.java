package com.example.AttendanceManage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_data")
@Getter
@Setter
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String loginId;

    @Column
    private String password;

    @Column
    private String tel;

    @Column
    private String email;
}
