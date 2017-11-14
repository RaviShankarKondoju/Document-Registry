package se.softhouse.notes.services;

import se.softhouse.notes.db.entity.DocumentRegistry;

import java.util.List;

public interface DocumentRegistryService {

    List<DocumentRegistry> getDocumentRegistry();

    void createDocumentRegistry(DocumentRegistry documentRegistry);

    DocumentRegistry getDocumentRegistryBy(int id);

    void updateDocumentRegistry(DocumentRegistry documentRegistry);

    void deleteDocumentRegistryBy(int id);
}
