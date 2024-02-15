package QuanLy.com.example.demo.service;

import QuanLy.com.example.demo.entity.Project;
import QuanLy.com.example.demo.repository.ProjectRepository;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) throws ChangeSetPersister.NotFoundException {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public Project createProject(Project project) {
        return createProject(project);
    }

    public Project updateProject(Long id, Project project) {
        return updateProject(id, project);
    }
    public boolean deleteProject(Long id) {
        deleteProject(id);
        return false;
    }
}
