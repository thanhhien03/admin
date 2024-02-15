package QuanLy.com.example.demo.repository;

import QuanLy.com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
