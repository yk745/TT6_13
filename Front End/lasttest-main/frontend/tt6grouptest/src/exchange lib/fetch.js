import exchangeRates from "./rates.json";

const sleep = (time) => new Promise((res) => setTimeout(res, time));

export async function fetch(url) {
  const [, search = ""] = url.split("?");
  const params = new URLSearchParams(search);
  await sleep(400);
  const symbols = new Set((params.get("symbols") || "").split(","));
  const base = params.get("base");
  const rates = exchangeRates[base];
  return {
    async json() {
      return {
        success: true,
        rates,
      };
    },
  };
}
