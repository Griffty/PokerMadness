// Participant file. Mock observations, not the final engine API.
export function decide(observation) {
  const legal = observation.legal_actions;

  if (legal.includes("check")) {
    return { action: "check" };
  }

  // TODO 1: Before folding, call if calling is legal and
  // observation.to_call <= 2 * observation.big_blind.
  //
  // TODO 2: Change one rule using your cards, street, or remaining stack.
  // Explain the change and check that the returned action remains legal.

  if (legal.includes("fold")) {
    return { action: "fold" };
  }

  throw new Error("No supported action in this workshop observation");
}
