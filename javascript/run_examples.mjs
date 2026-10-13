// Local behavior checks. This is not a game engine or security sandbox.
import { readFileSync } from "node:fs";
import { decide as starter } from "./starter.mjs";
import { decide as baseline } from "./baseline.mjs";
import { decide as improved } from "./improved.mjs";

const bots = { starter, baseline, improved };
const supported = new Set(["check", "call", "fold"]);
const args = process.argv.slice(2);
const botName = args[0] ?? "starter";
const reference = args[1] ?? botName;

if (
  args.length > 2 ||
  !Object.hasOwn(bots, botName) ||
  !Object.hasOwn(bots, reference)
) {
  console.log("Usage: run_examples.mjs [starter|baseline|improved] [reference]");
  process.exit(2);
}

const cases = JSON.parse(
  readFileSync(new URL("../examples/states.json", import.meta.url), "utf8")
).cases;
let legalCount = 0;
let referenceCount = 0;

for (const example of cases) {
  const observation = example.observation;
  const expected = example.expected[reference];
  try {
    const copiedObservation = JSON.parse(JSON.stringify(observation));
    const response = bots[botName](copiedObservation);
    if (
      response === null ||
      typeof response !== "object" ||
      Array.isArray(response) ||
      Object.keys(response).length !== 1 ||
      !Object.hasOwn(response, "action")
    ) {
      throw new Error("Return an object containing only the action field");
    }
    const name = response.action;
    if (typeof name !== "string" || !supported.has(name)) {
      throw new Error("This exercise supports check, call, and fold");
    }
    if (!observation.legal_actions.includes(name)) {
      throw new Error("The chosen action is not currently legal");
    }
    legalCount += 1;
    if (name === expected) referenceCount += 1;
    console.log(
      example.id + ": " + JSON.stringify(response) +
      " [legal; reference " + expected + "]"
    );
  } catch (error) {
    console.log(example.id + ": ERROR " + error.message);
  }
}

console.log("LEGAL " + legalCount + "/" + cases.length);
console.log("REFERENCE " + referenceCount + "/" + cases.length + " (" + reference + ")");
console.log("Reference matches are behavior checks, not poker scores.");
process.exitCode = legalCount === cases.length ? 0 : 1;
