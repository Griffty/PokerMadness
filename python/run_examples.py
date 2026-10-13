"""Local behavior checks. This is not a game engine or security sandbox."""

import copy
import json
import sys
from pathlib import Path

import baseline
import improved
import starter

BOTS = {
    "starter": starter.decide,
    "baseline": baseline.decide,
    "improved": improved.decide,
}
SUPPORTED = {"check", "call", "fold"}


def validate_action(action, observation):
    if not isinstance(action, dict) or set(action) != {"action"}:
        raise ValueError("Return an object containing only the action field")
    name = action["action"]
    if not isinstance(name, str) or name not in SUPPORTED:
        raise ValueError("This exercise supports check, call, and fold")
    if name not in observation["legal_actions"]:
        raise ValueError("The chosen action is not currently legal")
    return name


def main():
    args = sys.argv[1:]
    bot_name = args[0] if args else "starter"
    reference = args[1] if len(args) > 1 else bot_name
    if len(args) > 2 or bot_name not in BOTS or reference not in BOTS:
        print("Usage: run_examples.py [starter|baseline|improved] [reference]")
        return 2

    cases_path = Path(__file__).resolve().parents[1] / "examples" / "states.json"
    cases = json.loads(cases_path.read_text(encoding="utf-8"))["cases"]
    legal_count = 0
    reference_count = 0

    for case in cases:
        observation = case["observation"]
        expected = case["expected"][reference]
        try:
            response = BOTS[bot_name](copy.deepcopy(observation))
            name = validate_action(response, observation)
            legal_count += 1
            if name == expected:
                reference_count += 1
            encoded = json.dumps(response, separators=(",", ":"))
            print(case["id"] + ": " + encoded + " [legal; reference " + expected + "]")
        except Exception as error:
            print(case["id"] + ": ERROR " + str(error))

    print("LEGAL " + str(legal_count) + "/" + str(len(cases)))
    print("REFERENCE " + str(reference_count) + "/" + str(len(cases)) + " (" + reference + ")")
    print("Reference matches are behavior checks, not poker scores.")
    return 0 if legal_count == len(cases) else 1


if __name__ == "__main__":
    sys.exit(main())
