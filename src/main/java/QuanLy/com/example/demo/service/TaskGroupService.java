package QuanLy.com.example.demo.service;

import QuanLy.com.example.demo.entity.TaskGroup;
import QuanLy.com.example.demo.repository.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;


@Service
public class TaskGroupService {
    private final TaskGroupRepository taskGroupRepository;

    @Autowired
    public TaskGroupService(TaskGroupRepository taskGroupRepository) {
        this.taskGroupRepository = taskGroupRepository;
    }

    public List<TaskGroup> getAllTaskGroups() {
        List<TaskGroup> taskGroups = taskGroupRepository.findAll();
        return taskGroups;
    }

    public TaskGroup getTaskGroupById(Long id) throws ChangeSetPersister.NotFoundException {
        TaskGroup taskGroup = taskGroupRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return taskGroup;
    }
}