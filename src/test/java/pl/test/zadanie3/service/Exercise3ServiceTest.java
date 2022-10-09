package pl.test.zadanie3.service;

import org.junit.Before;
import org.junit.Test;
import pl.test.zadanie3.dao.FileDaoImpl;
import pl.test.zadanie3.model.WorkspaceFile;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Exercise3ServiceTest {

    private Exercise3Service exercise3Service;

    private FileDaoImpl fileDaoImpl;

    private final LocalDateTime lastTime1 = LocalDateTime.of(2022, 1, 1, 12, 34);
    private final LocalDateTime lastTime2 = LocalDateTime.of(2022, 2, 1, 12, 34);
    private final LocalDateTime lastTime3 = LocalDateTime.of(2022, 3, 1, 12, 34);
    private final WorkspaceFile w1 = new WorkspaceFile("Dupa.java", "..\\Dupa\\src\\main\\java\\pl\\kurs\\Dupa.java", 122, lastTime1.toInstant(ZoneOffset.UTC), lastTime2.toInstant(ZoneOffset.UTC));
    private final WorkspaceFile w2 = new WorkspaceFile("Dupa.java", "..\\Dupa\\src\\main\\java\\pl\\kurs\\Dupa.java", 122, lastTime2.toInstant(ZoneOffset.UTC), lastTime3.toInstant(ZoneOffset.UTC));

    public Exercise3ServiceTest() {
    }


    @Before
    public void init() {
        exercise3Service = new Exercise3Service(fileDaoImpl);
    }

    @Test
    public void shouldReturnLastLastModifiedFile() {
        assertEquals(w2, exercise3Service.getLastModifiedFile(Arrays.asList(w1, w2)));
    }

    @Test
    public void shouldReturnCountLastModifiedFiles() {
        assertEquals(1, exercise3Service.countLastModifiedFiles(Arrays.asList(w1, w2), lastTime2.toInstant(ZoneOffset.UTC)));
    }


}