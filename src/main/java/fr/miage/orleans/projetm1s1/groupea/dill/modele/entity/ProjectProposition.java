package fr.miage.orleans.projetm1s1.groupea.dill.modele.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ProjectProposition")
public class ProjectProposition {
// exemple pour faire des tests on changera les chomps plutard
    @Id
    private String id;

    public String getId() {
        return id;
    }

    private String raisonSociale ;
    private int effectif;
    private String personneReferente;
    private String projectRefrence;
    private String categorieProjet;
    private String infoProject;

    public ProjectProposition() {

    }





}
