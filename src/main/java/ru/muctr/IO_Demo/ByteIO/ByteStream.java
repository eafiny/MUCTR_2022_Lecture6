package ru.muctr.IO_Demo.ByteIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        //чтение байт из файла Read.txt и запись их в файл Write.txt с помощью байтовых потоков
        try {
            fin = new FileInputStream("Read.txt");
            fout = new FileOutputStream("Write.txt");

            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException exc) {
                System.out.println("Ошибка при закрытии входного файла");
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии выходного файла");
            }
        }
    }
}

