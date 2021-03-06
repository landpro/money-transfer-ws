package pro.landlabs.money.transfer;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static final String BASE_URI = "http://localhost:8080/";

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

        logger.info(String.format("Money Transfer Service started. Endpoints: "
                + "%sapplication.wadl\nHit enter to shutdown...", BASE_URI));

        System.in.read();

        server.shutdownNow();
    }

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig()
                .packages("pro.landlabs.money.transfer")
                .register(MyObjectMapperProvider.class)
                .register(new DependencyBinder())
                .register(JacksonFeature.class);

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

}
