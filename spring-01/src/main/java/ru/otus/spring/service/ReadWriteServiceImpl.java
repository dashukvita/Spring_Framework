package ru.otus.spring.service;

import java.io.PrintStream;
import java.util.Scanner;

public class ReadWriteServiceImpl implements ReadWriteService {

    private final Scanner reader;
    private final PrintStream writer;

    public ReadWriteServiceImpl() {
        this.reader = new Scanner(System.in);
        this.writer = new PrintStream(System.out);
    }

    @Override
    public void write(String line) {
        writer.println(line);
    }

    @Override
    public void writeResult(String format, Object... args) {
        writer.printf(format, args);
    }

    @Override
    public String read() {
        return reader.nextLine();
    }
}
