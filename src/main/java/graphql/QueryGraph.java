package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

import java.util.List;

public class QueryGraph implements GraphQLRootResolver {

    private final ModuleBusiness moduleBusiness;
    private final UniteEnseignementBusiness ueBusiness;

    public QueryGraph(ModuleBusiness moduleBusiness, UniteEnseignementBusiness ueBusiness) {
        this.moduleBusiness = moduleBusiness;
        this.ueBusiness = ueBusiness;
    }

    public List<Module> allModules() {
        return moduleBusiness.getAllModules();
    }

    public Module moduleById(String id) {
        return moduleBusiness.getModuleByMatricule(id);
    }

    public List<UniteEnseignement> allUnites() {
        return ueBusiness.getListeUE();
    }

    public UniteEnseignement uniteById(int code) {
        return ueBusiness.getUEByCode(code);
    }
}
