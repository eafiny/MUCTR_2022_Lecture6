package ru.muctr.IO_Demo.StringIO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Movie implements Comparable<Movie>{
    private String title;
    private String producer;

    @Override
    public int compareTo(Movie o) {
        return getTitle().compareToIgnoreCase(o.getTitle());
    }
}


