// Completed live-coding example. The threshold is only a teaching choice.
export function decide(observation) {
  const legal = observation.legal_actions;

  if (legal.includes("check")) {
    return { action: "check" };
  }

  const cheapCall = observation.to_call <= 2 * observation.big_blind;
  if (legal.includes("call") && cheapCall) {
    return { action: "call" };
  }

  if (legal.includes("fold")) {
    return { action: "fold" };
  }

  throw new Error("No supported action in this workshop observation");
}
