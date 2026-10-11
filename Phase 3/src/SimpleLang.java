import main.ast.core.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
// start: Phase 3 analyzer import
import main.visitor.ReachabilityAnalyzer;
import main.visitor.name.NameAnalyzer;
import main.visitor.reachability.ReachabilityResult;
// end: Phase 3 analyzer import

import java.io.IOException;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);

        SimpleLangLexer lexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SimpleLangParser parser = new SimpleLangParser(tokens);

        SimpleLangParser.ProgramContext parseTree = parser.program();
        Program program = parseTree.programRet;

        // start: Phase 3 semantic-analysis execution
        NameAnalyzer analyzer = new NameAnalyzer();
        for (String diagnostic : analyzer.analyze(program)) {
            System.out.println(diagnostic);
        }

        ReachabilityAnalyzer reachabilityAnalyzer =
                new ReachabilityAnalyzer();
        ReachabilityResult reachability =
                reachabilityAnalyzer.analyze(program);
        for (String warning : reachability.warnings()) {
            System.out.println(warning);
        }
        reachability.writeOptimizedSource(
                Path.of(args[0]),
                parseTree.topLevelDecl()
        );
        // end: Phase 3 semantic-analysis execution
    }
}
