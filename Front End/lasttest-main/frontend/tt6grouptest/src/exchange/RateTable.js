export function RateTable({ currencyData, amount }) {
  return (
    <table className="ui very basic collapsing celled table">
      <tbody>
        {Object.entries(currencyData).map(([code, rate]) => {
          const exchangeAmount = amount * rate || 0.0;
          return (
            <tr key={code}>
              <td>{code}</td>
              <td>
                {exchangeAmount.toLocaleString("en", {
                  style: "currency",
                  currency: code,
                })}
              </td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
}
