package fr.miage.orleans.projetm1s1.groupea.dill.modele.services;

import fr.miage.orleans.projetm1s1.groupea.dill.modele.entity.ProjectProposition;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProjectPropService {

    public void create(ProjectProposition projProposition);

    public void delete(String id);

    public void deleteAll();

    public Optional<Optional<ProjectProposition>> findById(String id);

    public Collection<ProjectProposition> findByPersonneReferente(String personneReferente);
    public ProjectProposition findByProjectReference(String projectReference);

    public List<ProjectProposition> findAll();



}
