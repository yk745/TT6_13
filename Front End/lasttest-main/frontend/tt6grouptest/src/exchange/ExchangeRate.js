import { useState, useCallback, useEffect } from "react";
import { RateTable } from "./RateTable";
import { CurrencyCodePicker } from "./CurrencyCodePicker";
import {AmountField} from './AmountField';
import { getExchangeRates } from "../api";

const supportedCurrencies = ["USD", "EUR", "JPY", "CAD", "GBP", "SGD"];

export function ExchangeRate() {
  const [amount, setAmount] = useState("1.00");
  const [currencyCode, setCurrencyCode] = useState("SGD");
  const [currencyData, setCurrencyData] = useState({ SGD: 1.0 });

  useEffect(() => {
    getExchangeRates(currencyCode, supportedCurrencies).then((rates) => {
      setCurrencyData(rates);
    });
  }, [currencyCode]);

  const handleCurrencyCode = useCallback(
    (e) => setCurrencyCode(e.target.value),
    []
  );

  const handleAmountChange = useCallback((e) => {
    let newAmount = e.target.value;
    setAmount(newAmount);
  }, []);

  return (
    <>
      <section style={{'paddingLeft':'50px', 'paddingBottom':'20px'}}>
        <h1 className="ExchangeRate-header">
          Exchange Rates{" "}
          <CurrencyCodePicker
            supportedCurrencies={supportedCurrencies}
            currencyCode={currencyCode}
            onChange={handleCurrencyCode}
          />
        </h1>
      </section>
      <section style={{'paddingLeft':'50px', 'paddingBottom':'20px'}}>
        <AmountField amount={amount} onChange={handleAmountChange} />
      </section>
      <section style={{'paddingLeft':'50px'}}>
        <RateTable currencyData={currencyData} amount={amount} />
      </section>
    </>
  );
}
