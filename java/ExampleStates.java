// Generated from examples/states.json by tools/sync_java_examples.py.
// Checked in as readable Java source, so no JSON dependency is needed.
public final class ExampleStates {
    public static ExampleCase[] all() {
        return new ExampleCase[] {
            new ExampleCase(
                "free_check",
                new Observation(
                    "flop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {new Card(14, "D"), new Card(9, "C"), new Card(7, "S")},
                    60, 0, 10, 990,
                    new String[] {"check", "bet"}),
                "check", "check", "check"),
            new ExampleCase(
                "cheap_call",
                new Observation(
                    "preflop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {},
                    25, 10, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "call", "call"),
            new ExampleCase(
                "two_blind_boundary",
                new Observation(
                    "preflop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {},
                    60, 20, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "call", "call"),
            new ExampleCase(
                "above_two_blinds",
                new Observation(
                    "preflop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {},
                    60, 21, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "fold", "fold"),
            new ExampleCase(
                "pair_bigger_call",
                new Observation(
                    "preflop",
                    new Card[] {new Card(12, "H"), new Card(12, "D")},
                    new Card[] {},
                    60, 30, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "fold", "call"),
            new ExampleCase(
                "weak_cheap_call",
                new Observation(
                    "preflop",
                    new Card[] {new Card(7, "D"), new Card(2, "C")},
                    new Card[] {},
                    60, 10, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "call", "call"),
            new ExampleCase(
                "weak_two_blind_call",
                new Observation(
                    "preflop",
                    new Card[] {new Card(7, "D"), new Card(2, "C")},
                    new Card[] {},
                    60, 20, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "call", "fold"),
            new ExampleCase(
                "pair_after_flop",
                new Observation(
                    "flop",
                    new Card[] {new Card(12, "H"), new Card(12, "D")},
                    new Card[] {new Card(14, "D"), new Card(9, "C"), new Card(7, "S")},
                    60, 30, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "fold", "fold"),
            new ExampleCase(
                "small_remaining_stack",
                new Observation(
                    "flop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {new Card(14, "D"), new Card(9, "C"), new Card(7, "S")},
                    60, 10, 10, 40,
                    new String[] {"fold", "call", "raise"}),
                "fold", "call", "fold"),
            new ExampleCase(
                "raising_unavailable",
                new Observation(
                    "preflop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {},
                    60, 10, 10, 990,
                    new String[] {"fold", "call"}),
                "fold", "call", "call"),
            new ExampleCase(
                "large_call",
                new Observation(
                    "flop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {new Card(14, "D"), new Card(9, "C"), new Card(7, "S")},
                    250, 100, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "fold", "fold"),
            new ExampleCase(
                "turn_free_check",
                new Observation(
                    "turn",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {new Card(14, "D"), new Card(9, "C"), new Card(7, "S"), new Card(2, "H")},
                    60, 0, 10, 990,
                    new String[] {"check", "bet"}),
                "check", "check", "check"),
            new ExampleCase(
                "short_all_in_call",
                new Observation(
                    "river",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {new Card(14, "D"), new Card(9, "C"), new Card(7, "S"), new Card(2, "H"), new Card(11, "C")},
                    60, 20, 10, 20,
                    new String[] {"fold", "call"}),
                "fold", "call", "fold"),
            new ExampleCase(
                "weak_cards_after_flop",
                new Observation(
                    "flop",
                    new Card[] {new Card(7, "D"), new Card(2, "C")},
                    new Card[] {new Card(14, "D"), new Card(9, "C"), new Card(7, "S")},
                    60, 20, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "call", "call"),
            new ExampleCase(
                "pair_above_four_blinds",
                new Observation(
                    "preflop",
                    new Card[] {new Card(12, "H"), new Card(12, "D")},
                    new Card[] {},
                    60, 41, 10, 990,
                    new String[] {"fold", "call", "raise"}),
                "fold", "fold", "fold"),
            new ExampleCase(
                "pair_four_blind_boundary",
                new Observation(
                    "preflop",
                    new Card[] {new Card(12, "H"), new Card(12, "D")},
                    new Card[] {},
                    60, 40, 10, 200,
                    new String[] {"fold", "call", "raise"}),
                "fold", "fold", "call"),
            new ExampleCase(
                "pair_stack_boundary",
                new Observation(
                    "preflop",
                    new Card[] {new Card(12, "H"), new Card(12, "D")},
                    new Card[] {},
                    60, 20, 10, 100,
                    new String[] {"fold", "call", "raise"}),
                "fold", "call", "call"),
            new ExampleCase(
                "pair_above_stack_limit",
                new Observation(
                    "preflop",
                    new Card[] {new Card(12, "H"), new Card(12, "D")},
                    new Card[] {},
                    60, 21, 10, 100,
                    new String[] {"fold", "call", "raise"}),
                "fold", "fold", "fold"),
            new ExampleCase(
                "different_big_blind",
                new Observation(
                    "preflop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {},
                    60, 40, 20, 980,
                    new String[] {"fold", "call", "raise"}),
                "fold", "call", "call"),
            new ExampleCase(
                "above_different_big_blind",
                new Observation(
                    "preflop",
                    new Card[] {new Card(14, "S"), new Card(13, "C")},
                    new Card[] {},
                    60, 41, 20, 980,
                    new String[] {"fold", "call", "raise"}),
                "fold", "fold", "fold"),
        };
    }
}
