import graphql.GraphQLEndpoint;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class main {
    public static void main(String[] args) throws Exception {
        int port = 5003;
        Server server = new Server(port);

        // Create context at a root path
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Register GraphQL endpoint servlet at /graphql
        ServletHolder graphqlServlet = new ServletHolder(new GraphQLEndpoint());
        context.addServlet(graphqlServlet, "/graphql");

        try {
            server.start();
            System.out.println("GraphQL server started on http://localhost:" + port + "/graphql");
            server.join();
        } finally {
            server.stop();
            server.destroy();
        }
    }
}
