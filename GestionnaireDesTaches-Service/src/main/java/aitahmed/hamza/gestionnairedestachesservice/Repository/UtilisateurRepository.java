package aitahmed.hamza.gestionnairedestachesservice.Repository;

import aitahmed.hamza.gestionnairedestachesservice.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "UserCollection", path = "UserPath") // seulement pour tester est savoir la diffenrence entre Path est CollectionResourceRel
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    Utilisateur findByEmail(String email); // http://localhost:8088/Utilisateurs/search/findByEmail?email=hamza@gmail.com

    Utilisateur findById(int id);

    Utilisateur findUtilisateurById( Integer id);

//    @Query("SELECT t.MesMembers FROM Equipe t JOIN Projet p ON p.id = :projectId AND p IN ( SELECT t.Projects  FROM Equipe t)")
//    @Query("SELECT t.MesMembers FROM Equipe t  where t IN (SELECT ProjectTeam from Projet where Projet.id = :projectID )")
//    List<Utilisateur> findUsersByProjectId(int projectId);

//    @Query("SELECT u FROM User u where u.id IN (Select tm.id from Equipe.MesMembers tm where Equipe.id = :TeamId ) OR u IN (Select t.Leader from Equipe t where t.id = :TeamId )")
//    @Query("select u from Utilisateur u Join Equipe On u IN ( Select t.mesMembers from Equipe t where t.id = :TeamId ) ")
//    List<Utilisateur> findMesMembersByEquipeId(Integer TeamId);

//    List<Utilisateur> findUtilisateursByMembreEquipeId(Integer TeamId);

    @Query("select u from Utilisateur u Join Equipe On u Not IN ( Select t.mesMembers from Equipe t where t.id = :TeamId ) ")
    List<Utilisateur> findUtilisateursIsNotMembreEquipe(Integer TeamId);

}