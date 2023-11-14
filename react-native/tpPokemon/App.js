import {StyleSheet, Text, View} from 'react-native';
import React from 'react';
import {Provider} from 'react-redux';
import {store} from './store/redux/store';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import HomePage from './components/HomePage';
import PokemonsLists from './components/PokemonsLists';
import DetailsPokemon from './components/DetailsPokemon';

const Stack = createNativeStackNavigator();

const App = () => {
  return (
    <Provider store={store}>
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen name="HomePage" component={HomePage} />
          <Stack.Screen
            name="PokemonsLists"
            component={PokemonsLists}
            options={{title: 'Pokedex'}}
          />
          <Stack.Screen
            name="DetailsPokemon"
            component={DetailsPokemon}
            options={{title: 'Pokemon'}}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  );
};

export default App;

const styles = StyleSheet.create({});
