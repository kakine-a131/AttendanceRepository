package com.example.AttendanceManage.repositories;

import com.example.AttendanceManage.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {
    public Optional<Attendance> findById(Integer id);
}
