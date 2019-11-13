package ch.jug.graalvm.list;

import java.io.File;
import java.util.Arrays;

public class App {
    public static void main(final String... args) {
        Arrays.stream(new File(".").listFiles())
              .forEach(System.out::println);
    }
}
