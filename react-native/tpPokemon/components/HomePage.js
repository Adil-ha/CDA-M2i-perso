import {Pressable, StyleSheet, Text, View} from 'react-native';
import React from 'react';

const HomePage = ({navigation}) => {
  const PokemonsButton = () => {
    navigation.navigate('PokemonsLists');
  };

  const PokedexButton = () => {
    navigation.navigate('DetailsPokemon');
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Attrapez-les tous, Pokemon !!</Text>
      <View style={styles.buttonContainer}>
        <Pressable
          style={({pressed}) => [
            styles.button,
            {backgroundColor: pressed ? '#006400' : '#008080'},
          ]}
          onPress={PokemonsButton}>
          <Text style={styles.buttonText}>Pokemons</Text>
        </Pressable>
        <Pressable
          style={({pressed}) => [
            styles.button,
            {backgroundColor: pressed ? '#87CEEB' : '#0000CD'},
          ]}
          onPress={PokedexButton}>
          <Text style={styles.buttonText}>Pokedex</Text>
        </Pressable>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
  },
  title: {
    fontSize: 40,
    marginBottom: 20,
    fontWeight: 'bold',
    color: 'black',
  },
  buttonContainer: {
    flexDirection: 'row',
  },
  button: {
    alignItems: 'center',
    justifyContent: 'center',
    borderRadius: 10,
    paddingVertical: 15,
    paddingHorizontal: 20,
    margin: 10,
  },
  buttonText: {
    color: 'white',
    fontSize: 25,
  },
});

export default HomePage;
