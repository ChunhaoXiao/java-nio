package com.example.javanio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class NioTest {

    @Test
    public void testCreateDir() {
        try {
            Path p = Paths.get("DataSet");
            if(Files.exists(p)) {
                System.out.println("path already exist");
            }else {
                Path createdPath = Files.createDirectories(p);
                System.out.println("DataSet folder created");
            }
        }catch (Exception e){

        }
    }

    @Test
    public void testCreateFile() throws IOException {
        Path file = Paths.get("DataSet/test.txt");
        if(Files.exists(file)) {
            System.out.println("file already exists");
        } else {
            Files.createFile(file);
            System.out.println("file created successfully");
        }
    }

    @Test
    public void testReadFile() throws IOException {
        Path file = Paths.get("DataSet/test.txt");
        List<String> contents = Files.readAllLines(file);
        System.out.println(contents);
    }

    @Test
    public  void testWriteToFile() throws IOException{
        Path file = Paths.get("DataSet/test1.txt");
        //Path newfile = Files.createFile(file);
        Files.write(file,"abcdefg123yyy".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void testAppendToFile() throws IOException {
        Path file = Paths.get("DataSet/test1.txt");
        String content = "appended contents";
        Files.write(file,content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }

    @Test
    public void testCopyFile() throws IOException{
        Path source = Paths.get("pom.xml");
        Path destination = Paths.get("DataSet/POM1.xml");
        Files.copy(source,destination);
        System.out.println("file copied");
    }

    @Test
    public void testListFiles() throws IOException{
        Path p = Paths.get("DataSet");
        Stream<Path> fs = Files.list(p);
        List<Path> data = fs.collect(Collectors.toList());
        System.out.println(data);

    }

    @Test
    public void  testDeleteFile() throws IOException {
        Path p = Paths.get("DataSet/test.txt");
        Files.delete(p);
        System.out.println("file deleted");
    }

}
