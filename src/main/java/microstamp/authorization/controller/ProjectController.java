package microstamp.authorization.controller;

import microstamp.authorization.data.Project;
import microstamp.authorization.dto.ProjectDto;
import microstamp.authorization.exception.NotFoundException;
import microstamp.authorization.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return new ResponseEntity<>(projectService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/externalId/{id}")
    public ResponseEntity<Project> findByExternalId(@PathVariable(name = "id") UUID id) {
        return new ResponseEntity<>(projectService.findByExternalId(id), HttpStatus.OK);
    }

    @GetMapping(path = {"user/{id}"})
    public ResponseEntity<List<Project>> findByUserId(@PathVariable long id) {
        return new ResponseEntity<>(projectService.findByUserId(id), HttpStatus.OK);
    }

    @GetMapping(path = {"user/externalId/{id}"})
    public ResponseEntity<List<Project>> findByUserExternalId(@PathVariable UUID id) {
        return new ResponseEntity<>(projectService.findByUserExternalId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> insert(@RequestBody ProjectDto projectDto) throws NotFoundException {
        return new ResponseEntity<>(projectService.insert(projectDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) throws NotFoundException {
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/externalId/{id}")
    public ResponseEntity<Void> deleteByExternalId(@PathVariable(name = "id") UUID id) throws NotFoundException {
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
