public final class Action {
    public final String action;

    public Action(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "{\"action\":\"" + action + "\"}";
    }
}
