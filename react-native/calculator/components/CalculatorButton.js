import {StyleSheet, Text, Pressable, View} from 'react-native';
import React from 'react';

const CalculatorButton = ({onPress, value, isDigit}) => {
  return (
    <Pressable
      onPress={onPress}
      style={({pressed}) => pressed && styles.presseditem}>
      <View style={isDigit ? styles.button : styles.buttonTwo}>
        <Text style={isDigit ? styles.buttonText : styles.buttonTextTwo}>
          {value}
        </Text>
      </View>
    </Pressable>
  );
};

export default CalculatorButton;

const styles = StyleSheet.create({
  button: {
    alignItems: 'center',
    justifyContent: 'center',
    width: 80,
    height: 80,
    margin: 5,
    backgroundColor: '#DDDDDD',
    borderRadius: 50,
    fontSize: 40,
  },
  buttonTwo: {
    alignItems: 'center',
    justifyContent: 'center',
    width: 80,
    height: 80,
    margin: 5,
    backgroundColor: 'gray',
    borderRadius: 15,
    fontSize: 40,
  },
  buttonText: {
    fontSize: 30,
    color: 'black',
  },
  buttonTextTwo: {
    fontSize: 30,
    color: 'white',
  },
  presseditem: {
    backgroundColor: 'yellow',
  },
});
