package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {
    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        ModuleBusiness mbRepo = new ModuleBusiness();
        UniteEnseignementBusiness UEBRepo = new UniteEnseignementBusiness();
        return SchemaParser.newParser()
                .file("schemas.graphqls")
                .resolvers(new QueryGraph(mbRepo, UEBRepo),
                        new MutationGraph(mbRepo, UEBRepo)
                ).build().makeExecutableSchema();
    }

}