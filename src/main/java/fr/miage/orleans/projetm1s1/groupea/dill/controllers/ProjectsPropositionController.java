package fr.miage.orleans.projetm1s1.groupea.dill.controllers;

import fr.miage.orleans.projetm1s1.groupea.dill.modele.entity.ProjectProposition;
import fr.miage.orleans.projetm1s1.groupea.dill.modele.services.ProjectPropService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/projectProposition")
public class ProjectsPropositionController {

    @Autowired
    @Qualifier(value="projectPropService")
    ProjectPropService projectPropService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ProjectProposition> getAllProjectsProposition() {
        logger.info("get projects propositions en cours ...");
        return projectPropService.findAll();
    }
    @GetMapping(value = "/{id}")
    public Optional<Optional<ProjectProposition>> getProjectProposition(@PathVariable String id) {

        return projectPropService.findById(id);
    }

   // public Create
    @PostMapping(value = "/create")
    public ResponseEntity<?> createOrUpdateProjectProposition(@RequestBody ProjectProposition projectProp) {
        projectPropService.create(projectProp);
        return new ResponseEntity("PropositionProject added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{projectRefrence}")
    public ResponseEntity<String>  deleteProjectProposition(@PathVariable String projectRefrence) {
        ProjectProposition projectProposition = projectPropService.findByProjectReference(projectRefrence);

        if (projectProposition == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        try {
            projectPropService.delete(projectProposition.getId());
            return new ResponseEntity<>(projectProposition.getId(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


    }









}
