package de.mattagohni.jlox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class ScannerTest {
    @Test
    @DisplayName("it returns lines of given file")
    void itReturnsLinesOfGivenFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        var bytes = Files.readAllBytes(Paths.get("src", "test", "resources", "scanner", "testInput.txt"));
         var scanner = new Scanner(new String(bytes));

         assertThat(scanner.scanTokens().length).isEqualTo(4);
    }
}