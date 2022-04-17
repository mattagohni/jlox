package de.mattagohni.jlox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;
import static org.assertj.core.api.Assertions.assertThat;

class InterpreterTest {

    private Interpreter interpreter;

    @BeforeEach
    void setUp() {
        this.interpreter = new Interpreter();
    }

    @Test
    @DisplayName("it exits with code 64 for too many args")
    void itAcceptsNotMoreThanOneParameter() throws Exception {
        var result = catchSystemExit(() -> {
            var args = new String[]{"a", "b"};
            this.interpreter.run(args);
        });

        assertThat(result).isEqualTo(64);
    }

}