package de.mattagohni.jlox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Interpreter {
    public void execute(String[] args) throws IOException {
        if(args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if(args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private void runFile(String pathToFile) throws IOException {
        var bytes = Files.readAllBytes(Paths.get(pathToFile));
        run(new String(bytes, Charset.defaultCharset()));
    }

    private void runPrompt() throws IOException {
        var input = new InputStreamReader(System.in);
        var reader = new BufferedReader(input);

        for(;;) {
            System.out.print("> ");
            var line = reader.readLine();
            if (line == null) {
                break;
            }
            run(line);
        }
    }

    private void run(String input) {
        var scanner = new Scanner(input);
        var tokens = scanner.scanTokens();

        for(var token : tokens) {
            System.out.println(token);
        }
    }
}
