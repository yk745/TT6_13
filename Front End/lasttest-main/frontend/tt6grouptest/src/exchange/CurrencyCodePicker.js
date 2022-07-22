export function CurrencyCodePicker({
  supportedCurrencies,
  currencyCode,
  onChange,
}) {
  return (
    <select className="ui compact menu" value={currencyCode} onChange={onChange} style={{'marginLeft':'20px', 'marginBottom':'10px'}}>
      {supportedCurrencies.map((code) => (
        <option key={code} value={code}>
          {code}
        </option>
      ))}
    </select>
  );
}
