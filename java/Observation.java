// Workshop-only observation fields. The engine interface will come later.
public final class Observation {
    public final String street;
    public final Card[] holeCards;
    public final Card[] board;
    public final int pot;
    public final int toCall;
    public final int bigBlind;
    public final int stack;
    public final String[] legalActions;

    public Observation(
            String street, Card[] holeCards, Card[] board, int pot,
            int toCall, int bigBlind, int stack, String[] legalActions) {
        this.street = street;
        this.holeCards = holeCards.clone();
        this.board = board.clone();
        this.pot = pot;
        this.toCall = toCall;
        this.bigBlind = bigBlind;
        this.stack = stack;
        this.legalActions = legalActions.clone();
    }

    public Observation copy() {
        return new Observation(
                street, holeCards, board, pot, toCall, bigBlind, stack, legalActions);
    }

    public boolean can(String action) {
        for (String legal : legalActions) {
            if (legal.equals(action)) return true;
        }
        return false;
    }
}
