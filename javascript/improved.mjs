// Optional examples. These thresholds have not been tested for poker profit.
export function decide(observation) {
  const legal = observation.legal_actions;

  if (legal.includes("check")) {
    return { action: "check" };
  }

  let callLimit = 2 * observation.big_blind;

  // Starting-card rules apply before the flop only.
  if (observation.street === "preflop") {
    const [first, second] = observation.hole_cards;
    const pair = first.rank === second.rank;
    const twoHighCards = first.rank >= 10 && second.rank >= 10;

    if (pair) {
      callLimit = 4 * observation.big_blind;
    } else if (!twoHighCards) {
      callLimit = observation.big_blind;
    }
  }

  // Spend at most one fifth of the currently remaining stack on this call.
  callLimit = Math.min(callLimit, Math.floor(observation.stack / 5));

  if (legal.includes("call") && observation.to_call <= callLimit) {
    return { action: "call" };
  }

  if (legal.includes("fold")) {
    return { action: "fold" };
  }

  throw new Error("No supported action in this workshop observation");
}
