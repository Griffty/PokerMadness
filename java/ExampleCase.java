public final class ExampleCase {
    public final String id;
    public final Observation observation;
    private final String starter;
    private final String baseline;
    private final String improved;

    public ExampleCase(
            String id, Observation observation, String starter,
            String baseline, String improved) {
        this.id = id;
        this.observation = observation;
        this.starter = starter;
        this.baseline = baseline;
        this.improved = improved;
    }

    public String expected(String reference) {
        if (reference.equals("starter")) return starter;
        if (reference.equals("baseline")) return baseline;
        if (reference.equals("improved")) return improved;
        throw new IllegalArgumentException("Unknown reference");
    }
}
