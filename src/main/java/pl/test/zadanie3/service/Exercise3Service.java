/*
przeskanuj katalog workspace na ktorym miales kursy
wrzuc do bazy danych wszystkie pliki java wg nastepujacego schematu:
nazwaPliku|lokalizacja|rozmiar|datastworzenia|dataostatniej|modyfikacji

nastepnie napisz metode ktora na podstawie tego co jest w bazie znajdzie:
- plik co byl modyfikowany ostatnio
- N plikow modyfikowanych ostatnio.
 */
package pl.test.zadanie3.service;

import pl.test.zadanie3.dao.FileDaoImpl;
import pl.test.zadanie3.model.WorkspaceFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.*;


public class Exercise3Service {
    private final FileDaoImpl fileDao;

    public Exercise3Service(FileDaoImpl fileDao) {
        this.fileDao = fileDao;
    }

    public void searchFiles(File file) throws IOException {
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                searchFiles(f);
            }
        } else if (file.toString().toLowerCase().endsWith(".java")) {
            BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            fileDao.save(new WorkspaceFile(
                    file.getName(),
                    file.getPath(),
                    attr.size(),
                    attr.creationTime().toInstant(),
                    attr.lastModifiedTime().toInstant()
            ));
        }
    }

    public WorkspaceFile getLastModifiedFile(List<WorkspaceFile> workspaceFileList) {
        return Optional.ofNullable(workspaceFileList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(WorkspaceFile::getLastModified))
                .orElseThrow();
    }

    public long countLastModifiedFiles(List<WorkspaceFile> workspaceFileList, Instant lastTime) {
        return Optional.ofNullable(workspaceFileList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(f -> f.getLastModified().isAfter(lastTime))
                .count();
    }


}
