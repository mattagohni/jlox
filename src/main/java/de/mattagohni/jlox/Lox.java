package de.mattagohni.jlox;

import java.io.IOException;

public class Lox {

    public static void main(String[] args) throws IOException {
        var interpreter = new Interpreter();
        interpreter.run(args);
    }
}