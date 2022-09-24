package pl.test.zadanie3.dao;

import pl.test.zadanie3.model.WorkspaceFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class FileDaoImpl implements FileDao{
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public FileDaoImpl(EntityManagerFactory factory, EntityManager entityManager) {
        this.factory = factory;
        this.entityManager = entityManager;
    }


    @Override
    public void save(WorkspaceFile file) {

    }

    @Override
    public WorkspaceFile load(String path) {
        return null;
    }

    @Override
    public List<WorkspaceFile> loadAll() {
        return null;
    }

    @Override
    public void cleanUp() {

    }
}
