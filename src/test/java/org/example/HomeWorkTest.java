package org.example;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    @Test
    void testCase() {
        runTest("case.%s");
    }



    private void runTest(String pattern) {
        execute(pattern);
        assertRun(pattern);
    }

    @SneakyThrows
    private void assertRun(String pattern) {
        String answer = Files.readString(Path.of("target/" + String.format(pattern, "answer")));
        String out = Files.readString(Path.of("frog/" + String.format(pattern, "out")));
        assertEquals(out, answer);
    }

    @SneakyThrows
    private void execute(String pattern) {
        try (
                InputStream in = new FileInputStream("frog/" + String.format(pattern, "in"));
                OutputStream answer = new FileOutputStream("target/" + String.format(pattern, "answer"), false);
        ) {
            HomeWork hw = new HomeWork();
            hw.frogSteps(in, answer);
        }

    }

}