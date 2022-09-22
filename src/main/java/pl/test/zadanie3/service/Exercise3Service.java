package pl.test.zadanie3.service;

/*
przeskanuj katalog workspace na ktorym miales kursy
wrzuc do bazy danych wszystkie pliki java wg nastepujacego schematu:
nazwaPliku|lokalizacja|rozmiar|datastworzenia|dataostatniej|modyfikacji

nastepnie napisz metode ktora na podstawie tego co jest w bazie znajdzie:
- plik co byl modyfikowany ostatnio
- N plikow modyfikowanych ostatnio.
 */


import java.io.File;
import java.nio.file.Path;

public class Exercise3Service {
    private Path path;

    public Exercise3Service(Path path) {
        this.path = path;
    }

    private void searchFiles(File file){
        for (File listFile : file.listFiles()) {
            if(listFile.isDirectory()){
                searchFiles(listFile);
            }else{

            }

        }


    }

}
