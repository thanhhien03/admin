package QuanLy.com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskGroup extends JpaRepository<TaskGroup, Long> {

}
