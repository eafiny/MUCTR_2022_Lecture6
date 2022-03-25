package ru.muctr.nio_Demo;

import ru.muctr.IO_Demo.StringIO.Movie;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * @author Evgenia Skichko
 */
public class NioDemo {
    public static void main(String[] args) {
        try {
            new NioDemo().go();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void go() throws IOException{
        Movie[] movies = new Movie[9];
        File file = new File("Read.txt");
        if (!file.exists()) {
            System.err.printf("File %s doesn't exist\n", file.getPath());
        } else {
            try {
                String[] lines = Files.readAllLines(Path.of("Read.txt")).toArray(new String[0]); //чтение сразу всех строк из файла
                for (int i = 0; i < lines.length; i++) {
                    String[] columns = lines[i].split(",");
                    movies[i] = new Movie(columns[0], columns[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Arrays.sort(movies);

        File file1 = new File("WriteMovie.txt");
            try (var writer = new BufferedWriter(new FileWriter(file1))){
                for(Movie m : movies){
                    writer.write(m.toString());
                    writer.newLine();
                }
            }
        pathInterface_Demo();
        classFiles_Demo();
        }

    private void classFiles_Demo() throws IOException{
        Path path1 = Files.createDirectory(Paths.get("First directory"));
        Path path2 = Files.createDirectory(Paths.get("Second directory"));
        Path path = Files.createFile(Paths.get(path1 + "\\MoveFile.txt"));
        Files.move(path, Paths.get(path2 + "\\MoveFile.txt"), REPLACE_EXISTING);

        Files.copy(Paths.get("Read.txt"), Paths.get(path2 + "\\Read.txt"), REPLACE_EXISTING);
        Files.delete(path1);
        //********************** Получить список файлов в папке ***********************************
        File fileDir = new File(String.valueOf(path2));
        File[] fileArray = fileDir.listFiles();
        for (File f: fileArray) {
            System.out.println(f.getName());
        }
    }

    private void pathInterface_Demo() {
        Path path = Paths.get("Read.txt").toAbsolutePath();
        System.out.println("Абсолютный путь: " + path);
        System.out.println("Абсолютный путь? " + path.isAbsolute());
        System.out.println("Имя файла: " + path.getFileName());
        System.out.println("Элемент пути №4 " + path.getName(3));
        System.out.println("Количество элементов в пути " + path.getNameCount());
        System.out.println("Родительская директория: " + path.getParent());
        System.out.println("Корневая директория: " + path.getRoot());
        System.out.println("Путь заканчивается на 'Read.txt'? " + path.endsWith("Read.txt"));
        System.out.println("Путь заканчивается на 'ad.txt'? " + path.endsWith("ad.txt"));
    }


}
