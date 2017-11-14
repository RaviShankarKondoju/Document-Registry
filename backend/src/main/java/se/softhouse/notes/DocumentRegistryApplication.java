package se.softhouse.notes;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import se.softhouse.notes.db.NoteDAO;
import se.softhouse.notes.db.DocumentRegistryDAO;
import se.softhouse.notes.resources.DocumentRegistryResource;
import se.softhouse.notes.resources.NoteResource;
import se.softhouse.notes.services.DocumentRegistryService;
import se.softhouse.notes.services.NoteService;
import se.softhouse.notes.services.impl.DocumentRegistryServiceDbImpl;
import se.softhouse.notes.services.impl.NoteServiceDbImpl;

/**
 * @todo: this class should be renamed to 'MyProjectConfiguration' for your projects
 */
public class DocumentRegistryApplication extends Application<DocumentRegistryConfiguration> {
    @Override
    public void run(DocumentRegistryConfiguration configuration, Environment environment) throws Exception {
        // setup database connection
        final DBI dbi = getDbiFor(configuration, environment);

        // data access objects
        final NoteDAO noteDAO = dbi.onDemand(NoteDAO.class);
        final DocumentRegistryDAO documentRegistryDAO = dbi.onDemand(DocumentRegistryDAO.class);


        // create table
       // noteDAO.createTable();
        documentRegistryDAO.createTable();

        // services
       // final NoteService noteService = new NoteServiceDbImpl(noteDAO);
        final DocumentRegistryService documentRegistryService = new DocumentRegistryServiceDbImpl(documentRegistryDAO);

        // resources
       // final NoteResource noteResource = new NoteResource(noteService);
        final DocumentRegistryResource documentRegistryResource = new DocumentRegistryResource(documentRegistryService);

        // environment
       // environment.jersey().register(noteResource);
        environment.jersey().register(documentRegistryResource);
    }

    private DBI getDbiFor(DocumentRegistryConfiguration configuration, Environment environment) {
        return new DBIFactory().build(environment, configuration.getDataSourceFactory(), "sqlite");
    }

    @Override
    public void initialize(Bootstrap<DocumentRegistryConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new DocumentRegistryApplication().run(args);
    }
}
