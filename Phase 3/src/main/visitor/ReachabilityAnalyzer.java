// start: Phase 3 reachability-analyzer facade
package main.visitor;

import main.ast.core.Program;
import main.visitor.reachability.ReachabilityEngineAnalyzer;
import main.visitor.reachability.ReachabilityResult;

public final class ReachabilityAnalyzer {
    private final ReachabilityEngineAnalyzer engine =
            new ReachabilityEngineAnalyzer();

    public ReachabilityResult analyze(Program program) {
        return engine.analyze(program);
    }
}
// end: Phase 3 reachability-analyzer facade
