import main.ast.core.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;

import java.io.IOException;
import java.util.ArrayList;

import main.visitor.CodeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);

        SimpleLangLexer lexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SimpleLangParser parser = new SimpleLangParser(tokens);

        Program program = parser.program().programRet;

        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.visit(program);

        System.out.println();
    }
}