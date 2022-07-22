export function AmountField({ amount, onChange }) {
  return (
    <form className="ui form" style={{'width': '200px'}}>
      <input
        aria-label="Amount in base currency"
        type="text"
        value={amount}
        onChange={onChange}
      />
    </form>
  );
}
