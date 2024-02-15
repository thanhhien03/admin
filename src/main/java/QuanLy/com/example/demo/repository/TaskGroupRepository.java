package QuanLy.com.example.demo.repository;

import QuanLy.com.example.demo.entity.TaskGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Repository
public interface TaskGroupRepository extends JpaRepository<TaskGroup, Long> {

    Optional<TaskGroup> findById(Long id);

    List<TaskGroup> findAll();

    TaskGroup save(TaskGroup taskGroup);

    void deleteById(Long id);




}
