"""Optional rule examples. These thresholds have not been tested for poker profit."""


def decide(observation):
    legal = observation["legal_actions"]

    if "check" in legal:
        return {"action": "check"}

    call_limit = 2 * observation["big_blind"]

    # Starting-card rules apply before the flop only.
    if observation["street"] == "preflop":
        first, second = observation["hole_cards"]
        pair = first["rank"] == second["rank"]
        two_high_cards = first["rank"] >= 10 and second["rank"] >= 10

        if pair:
            call_limit = 4 * observation["big_blind"]
        elif not two_high_cards:
            call_limit = observation["big_blind"]

    # Spend at most one fifth of the currently remaining stack on this call.
    call_limit = min(call_limit, observation["stack"] // 5)

    if "call" in legal and observation["to_call"] <= call_limit:
        return {"action": "call"}

    if "fold" in legal:
        return {"action": "fold"}

    raise ValueError("No supported action in this workshop observation")
