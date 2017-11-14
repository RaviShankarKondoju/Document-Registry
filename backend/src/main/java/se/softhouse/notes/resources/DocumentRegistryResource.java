package se.softhouse.notes.resources;

import se.softhouse.notes.db.entity.DocumentRegistry;
import se.softhouse.notes.services.DocumentRegistryService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/registry")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentRegistryResource {

    private final DocumentRegistryService documentRegistryService;

    public DocumentRegistryResource(DocumentRegistryService documentRegistryService) {this.documentRegistryService = documentRegistryService;}

    @GET
    public List<DocumentRegistry> getDocumentRegistry(){
        return documentRegistryService.getDocumentRegistry();
    }

    @GET
    @Path("/{id}")
    public DocumentRegistry getDocumentRegistry(@PathParam("id") int id){
        return documentRegistryService.getDocumentRegistryBy(id);
    }


    @PUT
    @Path("/{id}")
    public void updateDocumentRegistry(@PathParam("id") int id, @Valid @NotNull DocumentRegistry documentRegistry){
        documentRegistry.setId(id);
        documentRegistryService.updateDocumentRegistry(documentRegistry);
    }

    @POST
    public void createDócumentRegistry(@Valid @NotNull DocumentRegistry documentRegistry){
        documentRegistryService.createDocumentRegistry(documentRegistry);
    }

    @DELETE
    @Path("/{id}")
    public void deleteDocumentBy(@PathParam("id") int id){
        documentRegistryService.deleteDocumentRegistryBy(id);
    }
}
