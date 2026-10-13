"""Participant file. This uses mock observations, not the final engine API."""


def decide(observation):
    legal = observation["legal_actions"]

    if "check" in legal:
        return {"action": "check"}

    # TODO 1: Before folding, call if calling is legal and
    # observation["to_call"] <= 2 * observation["big_blind"].
    #
    # TODO 2: Change one rule using your cards, street, or remaining stack.
    # Explain the change and test that the returned action remains legal.

    if "fold" in legal:
        return {"action": "fold"}

    raise ValueError("No supported action in this workshop observation")
