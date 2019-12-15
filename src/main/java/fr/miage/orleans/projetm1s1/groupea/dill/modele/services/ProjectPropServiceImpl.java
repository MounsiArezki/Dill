package fr.miage.orleans.projetm1s1.groupea.dill.modele.services;
import fr.miage.orleans.projetm1s1.groupea.dill.modele.repository.ProjectPropRepository;
import fr.miage.orleans.projetm1s1.groupea.dill.modele.entity.ProjectProposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service("projectPropService")
public class ProjectPropServiceImpl implements ProjectPropService {

    @Autowired
    ProjectPropRepository projectPropRepository;


    @Override
    public void delete(String id) {
        projectPropRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        projectPropRepository.deleteAll();
    }

    @Override
    public Optional<Optional<ProjectProposition>> findById(String id) {
        Optional<ProjectProposition> projectsProposition= projectPropRepository.findById(id);
        return Optional.ofNullable(projectsProposition);
}

    @Override
    public Collection<ProjectProposition> findByPersonneReferente(String personneReferente) {
        Collection<ProjectProposition> listProject = projectPropRepository.findByPersonneReferente(personneReferente);
        return listProject;
    }

    @Override
    public ProjectProposition findByProjectReference(String projectReference) {
        return projectPropRepository.findByProjectReference(projectReference);
    }

    @Override
    public void create(ProjectProposition projProposition) {
       projectPropRepository.insert(projProposition);

    }



    @Override
    public List<ProjectProposition> findAll() {
        return projectPropRepository.findAll();
    }
}
