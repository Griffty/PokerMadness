// Completed live-coding example. The threshold is only a teaching choice.
public final class BaselineBot implements WorkshopBot {
    @Override
    public Action decide(Observation observation) {
        if (observation.can("check")) {
            return new Action("check");
        }

        boolean cheapCall = observation.toCall <= 2 * observation.bigBlind;
        if (observation.can("call") && cheapCall) {
            return new Action("call");
        }

        if (observation.can("fold")) {
            return new Action("fold");
        }

        throw new IllegalArgumentException(
                "No supported action in this workshop observation");
    }
}
