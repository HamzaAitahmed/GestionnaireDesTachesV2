package aitahmed.hamza.gestionnairedestachesservice.GraphQlController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.Equipe;
import aitahmed.hamza.gestionnairedestachesservice.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class EquipeGraphQLController {
    @Autowired private EquipeRepository equipeRepository;

    @QueryMapping
    public List<Equipe> Equipes()
    {
        System.out.println("Equipes [] ");
        return equipeRepository.findAll();
    }

    @QueryMapping
    public Equipe EquipeId(@Argument int id)
    {
        System.out.println("EquipeId : "+id);
        return equipeRepository.findById(id);
    }

    @MutationMapping
    public Equipe AjouterEquipe(@Argument Equipe equipe )
    {
        System.out.println("AjouterEquipe : ");
        return equipeRepository.save(equipe);
    }

    @MutationMapping
    public Equipe ModifierEquipe(@Argument int id, @Argument Equipe equipe)
    {
        System.out.println("ModifierEquipe id : "+id);
        return equipeRepository.findById(id);
    }

    @MutationMapping
    public boolean supprimerEquipe(@Argument int id)
    {
        System.out.println("DeleteEquipesById :"+id);
        equipeRepository.deleteById(id);
        return true;
    }
}
