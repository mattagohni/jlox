package de.mattagohni.jlox;

import java.util.List;

public class Scanner {
    private String inputToInterpret;

    public Scanner(String inputToInterpret) {
        this.inputToInterpret = inputToInterpret;
    }

    public String[] scanTokens() {
        return this.inputToInterpret.split("\n");
    }
}
