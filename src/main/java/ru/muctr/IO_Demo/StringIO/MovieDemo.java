package ru.muctr.IO_Demo.StringIO;

import java.io.*;
import java.util.Arrays;

/**
 * @author Evgenia Skichko
 */

//чтение строк из файла Read.txt, создание массива фильмов,
//запись сортированного массива фильмов в файл WriteMovie.txt с помощью символьных потоков
public class MovieDemo {
    public static void main(String[] args) {
        try {
            new MovieDemo().go();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void go() throws IOException{
        Movie[] movies = new Movie[9];
        int i = 0;
        File file = new File("Read.txt");
        System.out.println(file.getAbsoluteFile());
        if (!file.exists()) {
            System.err.printf("File %s doesn't exist\n", file.getPath());
        } else {
            try (var reader = new BufferedReader(new FileReader(file))) {
                String stringToSplit = new String();
                stringToSplit = reader.readLine();
                while (stringToSplit != null) {
                    String[] arr = stringToSplit.split(",");

                    Movie newMovie = new Movie(arr[0], arr[1]);
                    movies[i++] = newMovie;
                    stringToSplit = reader.readLine();
                }
            }
        }

        Arrays.sort(movies);

        File file1 = new File("WriteMovie.txt");
        if (file1.exists()) {
            System.err.printf("File %s already exists\n", file1.getPath());
        } else {
            try (var writer = new BufferedWriter(new FileWriter(file1))){
                for(Movie m : movies){
                    writer.write(m.toString());
                    writer.newLine();
                }
            }
        }
    }
    public void printToConsoleForTest(){
        System.out.print("Working");
    }
}
