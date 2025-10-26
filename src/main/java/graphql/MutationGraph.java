package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

public class MutationGraph implements GraphQLRootResolver {

    private final ModuleBusiness mbRepo;
    private final UniteEnseignementBusiness uebRepo;

    public MutationGraph(ModuleBusiness mbRepo, UniteEnseignementBusiness uebRepo) {
        this.mbRepo = mbRepo;
        this.uebRepo = uebRepo;
    }

    /**
     * ============ Les fonctions de l'unité d'enseignement ============
     */

    // Creation d'une unite d'enseignement
    public boolean createUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return uebRepo.addUniteEnseignement(ue);
    }

    // Suppression d'une unite d'enseignement
    public boolean deleteUniteEnseignement(int code) {
        return uebRepo.deleteUniteEnseignement(code);
    }

    // Modification d'une unite d'enseignement
    public boolean updateUniteEnseignement(int code, UniteEnseignement updatedUE) {
        return uebRepo.updateUniteEnseignement(code, updatedUE);
    }

    // Récuperation d'une unite d'enseignement par son code
    public UniteEnseignement getUEByCode(int code) {
        return uebRepo.getUEByCode(code);
    }

    /**
     * ============ Les fonctions de module ============
     */

    // Creation d'un module
    public boolean createModule(String matricule, String nom, int coefficient, int volumeHoraire, String type) {
        Module module = new Module(matricule, nom, coefficient, volumeHoraire, Module.TypeModule.valueOf(type));
        return mbRepo.addModule(module);
    }

    // Suppression d'un module
    public boolean deleteModule(String matricule) {
        return mbRepo.deleteModule(matricule);
    }

    // Modification d'un module
    public boolean updateModule(String matricule, Module updatedModule) {
        return mbRepo.updateModule(matricule, updatedModule);
    }

    // Récuperation d'un module par son matricule
    public Module getModuleByMatricule(String matricule) {
        return mbRepo.getModuleByMatricule(matricule);
    }
}
