package de.mattagohni.jlox;

import de.mattagohni.jlox.token.Token;
import de.mattagohni.jlox.token.TokenType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @ParameterizedTest(name = "it ignores whitespace")
    @ValueSource(
            strings = {
                    " ", "\t", "\r", "\n"
            }
    )
    void itIgnoresValues(String input) {
        var scanner = new Scanner(input);

        assertThat(scanner.scanTokens().size()).isEqualTo(1); // Only the EOF-token
    }

    @Test
    @DisplayName("it recognizes a valid single line String")
    void itHandlesSingleLineString() {
        var scanner = new Scanner("\"das ist ein ziemlich langer string\"");

        Token token = scanner.scanTokens().get(0);

        assertThat(token.getType()).isEqualTo(TokenType.STRING);
        assertThat(token.getLine()).isEqualTo(1);
        assertThat(token.getLexeme()).isEqualTo("\"das ist ein ziemlich langer string\"");
        assertThat(token.getLiteral()).isEqualTo("das ist ein ziemlich langer string");
    }

    @Test
    @DisplayName("it recognizes a valid multi line String")
    void itHandlesMultiLineString() {
        var scanner = new Scanner("\"das ist ein ziemlich langer string\nmit einem Umbruch mittendrin\"");

        Token token = scanner.scanTokens().get(0);

        assertThat(token.getType()).isEqualTo(TokenType.STRING);
        assertThat(token.getLine()).isEqualTo(2);
        assertThat(token.getLexeme()).isEqualTo("\"das ist ein ziemlich langer string\nmit einem Umbruch mittendrin\"");
        assertThat(token.getLiteral()).isEqualTo("das ist ein ziemlich langer string\nmit einem Umbruch mittendrin");
    }
}