package pl.test.zadanie3.service;

/*
przeskanuj katalog workspace na ktorym miales kursy
wrzuc do bazy danych wszystkie pliki java wg nastepujacego schematu:
nazwaPliku|lokalizacja|rozmiar|datastworzenia|dataostatniej|modyfikacji

nastepnie napisz metode ktora na podstawie tego co jest w bazie znajdzie:
- plik co byl modyfikowany ostatnio
- N plikow modyfikowanych ostatnio.
 */


import pl.test.zadanie3.dao.FileDaoImpl;
import pl.test.zadanie3.model.WorkspaceFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;


public class Exercise3Service {
    private Path path;
    private FileDaoImpl fileDao;

    public Exercise3Service(String path, FileDaoImpl fileDao) {
        this.path = Paths.get(path);
        this.fileDao = fileDao;
    }

    private void searchFiles(Path path) throws IOException {
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        if (attr.isDirectory()) {
            for (Path p : path) {
                searchFiles(p);
            }
        } else if (path.toString().toLowerCase().endsWith(".java")) {
            fileDao.save(new WorkspaceFile(
                    attr.toString(),
                    path.toString(),
                    attr.size(),
                    attr.creationTime(),
                    attr.lastModifiedTime()
            ));
        }

    }

}
