package se.softhouse.notes.services.impl;

import se.softhouse.notes.db.DocumentRegistryDAO;
import se.softhouse.notes.db.entity.DocumentRegistry;
import se.softhouse.notes.exceptions.NoteExceptions;
import se.softhouse.notes.services.DocumentRegistryService;

import java.util.List;

public class DocumentRegistryServiceDbImpl implements DocumentRegistryService {

    private final DocumentRegistryDAO documentRegistryDAO;

    public DocumentRegistryServiceDbImpl(DocumentRegistryDAO documentRegistryDAO) {this.documentRegistryDAO = documentRegistryDAO;}


    @Override
    public List<DocumentRegistry> getDocumentRegistry() {
        return documentRegistryDAO.selectAll();
    }

    @Override
    public void createDocumentRegistry(DocumentRegistry documentRegistry) {
        documentRegistryDAO.insert(documentRegistry);

    }

    @Override
    public DocumentRegistry getDocumentRegistryBy(int id) {
        return documentRegistryDAO.get(id).orElseThrow(NoteExceptions.NOT_FOUND);
    }

    @Override
    public void updateDocumentRegistry(DocumentRegistry documentRegistry) {
    documentRegistryDAO.update(documentRegistry);
    }

    @Override
    public void deleteDocumentRegistryBy(int id) {
    documentRegistryDAO.delete(id);
    }
}
