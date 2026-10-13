"""Completed live-coding example. The call threshold is only a teaching choice."""


def decide(observation):
    legal = observation["legal_actions"]

    if "check" in legal:
        return {"action": "check"}

    cheap_call = observation["to_call"] <= 2 * observation["big_blind"]
    if "call" in legal and cheap_call:
        return {"action": "call"}

    if "fold" in legal:
        return {"action": "fold"}

    raise ValueError("No supported action in this workshop observation")
