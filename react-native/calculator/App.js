import {StyleSheet, View} from 'react-native';
import React from 'react';
import Calculator from './components/Calculator';

const App = () => {
  return <Calculator style={[styles.container]} />;
};

export default App;

const styles = StyleSheet.create({
  container: {
    backgroundColor: 'black',
  },
});
