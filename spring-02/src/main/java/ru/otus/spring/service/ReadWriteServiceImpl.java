package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ReadWriteServiceImpl implements ReadWriteService {

    private final Scanner reader;
    private final PrintStream writer;

    public String read() {
        return reader.nextLine();
    }

    public String write(String message) {
        writer.println(message);
        return message;
    }
}