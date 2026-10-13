// Participant file. Mock observations, not the final engine API.
public final class StarterBot implements WorkshopBot {
    @Override
    public Action decide(Observation observation) {
        if (observation.can("check")) {
            return new Action("check");
        }

        // TODO 1: Before folding, call if calling is legal and
        // observation.toCall <= 2 * observation.bigBlind.
        //
        // TODO 2: Change one rule using your cards, street, or remaining stack.
        // Explain the change and check that the returned action remains legal.

        if (observation.can("fold")) {
            return new Action("fold");
        }

        throw new IllegalArgumentException(
                "No supported action in this workshop observation");
    }
}
