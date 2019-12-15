package fr.miage.orleans.projetm1s1.groupea.dill.modele.repository;

import fr.miage.orleans.projetm1s1.groupea.dill.modele.entity.ProjectProposition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProjectPropRepository extends MongoRepository<ProjectProposition, String > {

    @Query("{ 'personneReferente' : ?0 }")
    Collection<ProjectProposition> findByPersonneReferente(String personneReferente);

    @Query("{ 'projectReference' : ?0 }")
    ProjectProposition findByProjectReference(String projectReference);




}
