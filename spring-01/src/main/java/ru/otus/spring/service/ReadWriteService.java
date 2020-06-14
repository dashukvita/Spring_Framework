package ru.otus.spring.service;

public interface ReadWriteService {
    void write(String line);
    void writeResult(String format, Object... args);
    String read();
}
