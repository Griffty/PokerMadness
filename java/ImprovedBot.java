// Optional examples. These thresholds have not been tested for poker profit.
public final class ImprovedBot implements WorkshopBot {
    @Override
    public Action decide(Observation observation) {
        if (observation.can("check")) {
            return new Action("check");
        }

        int callLimit = 2 * observation.bigBlind;

        // Starting-card rules apply before the flop only.
        if (observation.street.equals("preflop")) {
            Card first = observation.holeCards[0];
            Card second = observation.holeCards[1];
            boolean pair = first.rank == second.rank;
            boolean twoHighCards = first.rank >= 10 && second.rank >= 10;

            if (pair) {
                callLimit = 4 * observation.bigBlind;
            } else if (!twoHighCards) {
                callLimit = observation.bigBlind;
            }
        }

        // Spend at most one fifth of the currently remaining stack on this call.
        callLimit = Math.min(callLimit, observation.stack / 5);

        if (observation.can("call") && observation.toCall <= callLimit) {
            return new Action("call");
        }

        if (observation.can("fold")) {
            return new Action("fold");
        }

        throw new IllegalArgumentException(
                "No supported action in this workshop observation");
    }
}
