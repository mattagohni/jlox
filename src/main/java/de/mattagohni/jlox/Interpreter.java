package de.mattagohni.jlox;

public class Interpreter {
    public void run(String[] args) {
        if(args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        }
    }
}
