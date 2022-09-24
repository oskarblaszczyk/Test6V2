package pl.test.zadanie3.model;


import java.nio.file.attribute.FileTime;
import java.time.LocalDate;

public class WorkspaceFile {

    private String fileName;
    private String path;
    private long size;
    private FileTime created;
    private FileTime lastModified;

    public WorkspaceFile(String fileName, String path, long size, FileTime created, FileTime lastModified) {
        this.fileName = fileName;
        this.path = path;
        this.size = size;
        this.created = created;
        this.lastModified = lastModified;
    }
}
