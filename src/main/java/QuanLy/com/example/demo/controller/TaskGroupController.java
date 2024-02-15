package QuanLy.com.example.demo.controller;

import QuanLy.com.example.demo.entity.TaskGroup;
import QuanLy.com.example.demo.repository.TaskGroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task_group")
public class TaskGroupController {
    private final TaskGroupRepository taskGroupRepository;

    public TaskGroupController(TaskGroupRepository taskGroupRepository) {
        this.taskGroupRepository = taskGroupRepository;
    }

    @GetMapping
    public ResponseEntity<List<TaskGroup>> getAllTaskGroups() {
        List<TaskGroup> taskGroups = taskGroupRepository.findAll();
        return ResponseEntity.ok(taskGroups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskGroup> getTaskGroupById(@PathVariable("id") Long id) {
        Optional<TaskGroup> taskGroup = taskGroupRepository.findById(id);
        if (taskGroup.isPresent()) {
            return ResponseEntity.ok(taskGroup.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TaskGroup> createTaskGroup(@RequestBody TaskGroup taskGroup) {
        TaskGroup createdTaskGroup = taskGroupRepository.save(taskGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskGroup> updateTaskGroup(@PathVariable("id") Long id, @RequestBody TaskGroup taskGroup) {
        Optional<TaskGroup> existingTaskGroup = taskGroupRepository.findById(id);
        if (existingTaskGroup.isPresent()) {
            taskGroup.setId(id);
            TaskGroup updatedTaskGroup = taskGroupRepository.save(taskGroup);
            return ResponseEntity.ok(updatedTaskGroup);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskGroup(@PathVariable("id") Long id) {
        Optional<TaskGroup> taskGroup = taskGroupRepository.findById(id);
        if (taskGroup.isPresent()) {
            taskGroupRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
