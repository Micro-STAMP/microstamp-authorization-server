package microstamp.authorization.service;

import microstamp.authorization.data.Project;
import microstamp.authorization.data.User;
import microstamp.authorization.dto.ProjectDto;
import microstamp.authorization.exception.NotFoundException;
import microstamp.authorization.repository.ProjectRepository;
import microstamp.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) throws NotFoundException {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project", id.toString()));
    }

    public List<Project> findByUserId(long id) {
        return projectRepository.findByUserId(id);
    }

    public List<Project> findByUserExternalId(UUID userExternalId) {
        User user = userRepository.findByExternalId(userExternalId);

        return projectRepository.findByUserId(user.getId());
    }

    public Project findByExternalId(UUID externalId) {
        return projectRepository.findByExternalId(externalId);
    }

    public Project insert(ProjectDto projectDto) throws NotFoundException {
        User user = userRepository.findByExternalId(projectDto.getUserExternalId());
        if (user == null)
            throw new NotFoundException("User", projectDto.getUserExternalId().toString());

        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());

        user.getProjects().add(project);
        projectRepository.save(project);

        return project;
    }

    public void delete(Long id) throws NotFoundException {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project", id.toString()));
        projectRepository.deleteById(project.getId());
    }

    public void delete(UUID id) throws NotFoundException {
        Project project = projectRepository.findByExternalId(id);
        if (project == null)
            throw new NotFoundException("Project", id.toString());
        projectRepository.deleteById(project.getId());
    }
}
