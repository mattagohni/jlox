package de.mattagohni.jlox;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScannerTest {
    @ParameterizedTest(name = "it recognizes {0}")
    @ValueSource(
            strings = {
                    "(", ")", "{", "}", ",", ".", "-",
                    "+", ";", "/", "*", "!", "!=", "=",
                    "==", "<", "<=", ">", ">="
            }
    )
    void itRecognizesSingleCharacterTokens(String input) {
        var scanner = new Scanner(input);

        assertThat(scanner.scanTokens().size()).isEqualTo(2); // The actual token + the EOF-token
    }
}