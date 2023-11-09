import React, {useState} from 'react';
import {StyleSheet, Text, View} from 'react-native';
import CalculatorButton from './CalculatorButton';

const Calculator = () => {
  const [display, setDisplay] = useState('0');
  const [firstValue, setFirstValue] = useState(null);
  const [operator, setOperator] = useState(null);
  const [waitingForOperand, setWaitingForOperand] = useState(false);

  const handleDigitPress = digit => {
    if (waitingForOperand) {
      setDisplay(String(digit));
      setWaitingForOperand(false);
    } else {
      setDisplay(display === '0' ? String(digit) : display + digit);
    }
  };

  const handleOperatorPress = nextOperator => {
    const inputValue = parseFloat(display);

    if (firstValue === null) {
      setFirstValue(inputValue);
    } else if (operator) {
      const currentValue = firstValue || 0;
      const newValue = performOperation(operator, currentValue, inputValue);
      setFirstValue(newValue);
      setDisplay(String(newValue));
    }

    setWaitingForOperand(true);
    setOperator(nextOperator);
  };

  const performOperation = (operation, value1, value2) => {
    switch (operation) {
      case '+':
        return value1 + value2;
      case '-':
        return value1 - value2;
      case 'x':
        return value1 * value2;
      case '/':
        return value1 / value2;
      default:
        return value2;
    }
  };

  const handleEquals = () => {
    const inputValue = parseFloat(display);

    if (operator && firstValue !== null) {
      const result = performOperation(operator, firstValue, inputValue);
      setDisplay(String(result));
      setFirstValue(null);
      setWaitingForOperand(true);
      setOperator(null);
    }
  };

  const handleClear = () => {
    setDisplay('0');
    setFirstValue(null);
    setOperator(null);
    setWaitingForOperand(false);
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Calculator</Text>
      <Text style={styles.display}>{display}</Text>
      <View style={styles.buttonRow}>
        <CalculatorButton onPress={() => handleClear()} value="AC" />
        <CalculatorButton onPress={() => handleDigitPress('^')} value="^" />
        <CalculatorButton onPress={() => handleDigitPress('%')} value="%" />
        <CalculatorButton onPress={() => handleOperatorPress('/')} value="/" />
      </View>
      <View style={styles.buttonRow}>
        <CalculatorButton
          onPress={() => handleDigitPress(7)}
          isDigit
          value="7"
        />
        <CalculatorButton
          onPress={() => handleDigitPress(8)}
          isDigit
          value="8"
        />
        <CalculatorButton
          onPress={() => handleDigitPress(9)}
          isDigit
          value="9"
        />
        <CalculatorButton onPress={() => handleOperatorPress('x')} value="x" />
      </View>
      <View style={styles.buttonRow}>
        <CalculatorButton
          onPress={() => handleDigitPress(4)}
          isDigit
          value="4"
        />
        <CalculatorButton
          onPress={() => handleDigitPress(5)}
          isDigit
          value="5"
        />
        <CalculatorButton
          onPress={() => handleDigitPress(6)}
          isDigit
          value="6"
        />
        <CalculatorButton onPress={() => handleOperatorPress('-')} value="-" />
      </View>
      <View style={styles.buttonRow}>
        <CalculatorButton
          onPress={() => handleDigitPress(1)}
          isDigit
          value="1"
        />
        <CalculatorButton
          onPress={() => handleDigitPress(2)}
          isDigit
          value="2"
        />
        <CalculatorButton
          onPress={() => handleDigitPress(3)}
          isDigit
          value="3"
        />
        <CalculatorButton onPress={() => handleOperatorPress('+')} value="+" />
      </View>
      <View style={styles.buttonRow}>
        <CalculatorButton onPress={() => handleEquals('.')} isDigit value="." />
        <CalculatorButton
          onPress={() => handleDigitPress(0)}
          isDigit
          value="0"
        />
        <CalculatorButton onPress={() => handleClear()} isDigit value="DEL" />
        <CalculatorButton onPress={() => handleEquals('=')} value="=" />
      </View>
    </View>
  );
};

export default Calculator;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'black',
  },
  title: {
    color: 'white',
    fontSize: 45,
    textAlign: 'right',
  },
  display: {
    fontSize: 90,
    marginBottom: 20,
    color: 'gray',
  },
  buttonRow: {
    flexDirection: 'row',
  },
});
