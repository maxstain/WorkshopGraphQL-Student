package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

public class QueryGraph implements GraphQLRootResolver {

    private ModuleBusiness mbRepo;
    private UniteEnseignementBusiness uebRepo;

    public QueryGraph(ModuleBusiness mbRepo, UniteEnseignementBusiness uebRepo) {
        this.mbRepo = mbRepo;
        this.uebRepo = uebRepo;
    }
}
