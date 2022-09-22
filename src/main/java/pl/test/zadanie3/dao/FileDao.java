package pl.test.zadanie3.dao;

import pl.test.zadanie3.model.WorkspaceFile;

public interface FileDao {

    void save(WorkspaceFile file);

    WorkspaceFile load (Long id);

    void cleanUp();
}
