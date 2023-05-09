package org.goafabric.encore.logic;

import org.goafabric.encore.controller.Callee;
import org.goafabric.encore.crossfunctional.DurationLog;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class CalleeLogic {
    public Callee sayMyName(String name) {
        return new Callee("0", "Your name is: " + name);
    }

    public Callee sayMyOtherName(String name) {
        return new Callee("0", "Your other name is: " + name);
    }

    public Callee save(Callee callee) {
        return new Callee("0", "Storing your message: " + callee.message());
    }
}