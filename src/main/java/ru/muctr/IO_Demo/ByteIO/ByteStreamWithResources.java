package ru.muctr.IO_Demo.ByteIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWithResources {
    public static void main(String[] args) throws IOException {
        int i;

        //блок try с ресурсами
        try (FileInputStream fin = new FileInputStream("Read.txt");
        FileOutputStream fout = new FileOutputStream("Write.txt")){
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}

