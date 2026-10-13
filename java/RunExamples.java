// Local behavior checks. This is not a game engine or security sandbox.
public final class RunExamples {
    private static WorkshopBot select(String name) {
        if (name.equals("starter")) return new StarterBot();
        if (name.equals("baseline")) return new BaselineBot();
        if (name.equals("improved")) return new ImprovedBot();
        return null;
    }

    public static void main(String[] args) {
        String botName = args.length > 0 ? args[0] : "starter";
        String reference = args.length > 1 ? args[1] : botName;
        WorkshopBot bot = select(botName);
        if (args.length > 2 || bot == null || select(reference) == null) {
            System.out.println("Usage: RunExamples [starter|baseline|improved] [reference]");
            System.exit(2);
        }

        ExampleCase[] cases = ExampleStates.all();
        int legalCount = 0;
        int referenceCount = 0;

        for (ExampleCase example : cases) {
            Observation observation = example.observation;
            String expected = example.expected(reference);
            try {
                Action response = bot.decide(observation.copy());
                if (response == null || response.action == null) {
                    throw new IllegalArgumentException("Return an action object");
                }
                String name = response.action;
                if (!(name.equals("check") || name.equals("call") || name.equals("fold"))) {
                    throw new IllegalArgumentException(
                            "This exercise supports check, call, and fold");
                }
                if (!observation.can(name)) {
                    throw new IllegalArgumentException("The chosen action is not currently legal");
                }
                legalCount++;
                if (name.equals(expected)) referenceCount++;
                System.out.println(
                        example.id + ": " + response + " [legal; reference " + expected + "]");
            } catch (Exception error) {
                System.out.println(example.id + ": ERROR " + error.getMessage());
            }
        }

        System.out.println("LEGAL " + legalCount + "/" + cases.length);
        System.out.println(
                "REFERENCE " + referenceCount + "/" + cases.length + " (" + reference + ")");
        System.out.println("Reference matches are behavior checks, not poker scores.");
        if (legalCount != cases.length) System.exit(1);
    }
}
