import { useState, useEffect } from "react";

const MysteryNumber = (props) => {
  const value = props.value;
  const [numberA, setNumberA] = useState("");
  const [numberB, setNumberB] = useState("");
  const [result, setResult] = useState(false);

  const numberAInputChanged = (e) => {
    setNumberA(e.target.value);
  };

  const NumberBInputChanged = (e) => {
    setNumberB(e.target.value);
  };
  const verififation = () => {
    if (result === value) {
      return false;
    } else return true;
  };

  useEffect(() => {
    setResult(+numberA * +numberB);
  }, [numberA, numberB]);

  return (
    <>
      <input type="number" value={numberA} onInput={numberAInputChanged} />
      <input type="number" value={numberB} onInput={NumberBInputChanged} />
      <p>
        {numberA}* {numberB} = {value}
      </p>
    </>
  );
};

export default MysteryNumber;
