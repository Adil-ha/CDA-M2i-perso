import React, {useState, useEffect} from 'react';
import {StyleSheet, Text, View, Image} from 'react-native';
import axios from 'axios';

const DetailsPokemon = ({route}) => {
  const {name, backgroundColor} = route.params;
  const [pokemonDetails, setPokemonDetails] = useState(null);
  const [evolutionChain, setEvolutionChain] = useState(null);

  useEffect(() => {
    const fetchPokemonDetails = async () => {
      try {
        const response = await axios.get(
          `https://pokeapi.co/api/v2/pokemon/${name}`,
        );
        setPokemonDetails(response.data);

        const speciesResponse = await axios.get(response.data.species.url);
        console.log(speciesResponse);
        const evolutionChainResponse = await axios.get(
          speciesResponse.data.evolution_chain.url,
        );
        setEvolutionChain(evolutionChainResponse.data);
      } catch (error) {
        console.error('Error fetching Pokemon details:', error);
      }
    };

    fetchPokemonDetails();
  }, [name]);

  if (!pokemonDetails || !evolutionChain) {
    return (
      <View style={styles.container}>
        <Text>Loading...</Text>
      </View>
    );
  }

  const {types, sprites, height, weight} = pokemonDetails;

  const flavorText =
    evolutionChain.flavor_text_entries &&
    evolutionChain.flavor_text_entries.length
      ? evolutionChain.flavor_text_entries[0].flavor_text
      : 'Description not available';

  return (
    <View style={styles.container}>
      <View style={[styles.header, {backgroundColor}]}>
        <Text style={styles.name}>{name}</Text>
        <Text style={styles.type}>
          {types.map(type => type.type.name).join(', ')}
        </Text>
        <View style={styles.imageContainer}>
          <Image source={{uri: sprites.front_default}} style={styles.image} />
        </View>
      </View>
      <Text style={styles.details}>Détails</Text>
      <Text style={styles.details}>{flavorText}</Text>
      <View style={styles.containerTabInfo}>
        <View style={styles.tabInfo}>
          <Text style={styles.info}>Height: {height / 10} cm</Text>
          <Text style={styles.info}>Weight: {weight / 10} kg</Text>
        </View>
      </View>
      <Text style={styles.details}>Chaîne d'évolutions</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {},
  header: {
    padding: 16,
    marginBottom: 16,
  },
  name: {
    fontSize: 40,
    fontWeight: 'bold',
    marginBottom: 8,
    color: 'white',
  },
  imageContainer: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  },
  image: {
    width: 150,
    height: 150,
    marginBottom: 8,
  },
  type: {
    color: 'white',
    fontSize: 20,
  },
  details: {
    color: 'black',
    fontSize: 24,
    fontWeight: 'bold',
    marginVertical: 10,
  },
  containerTabInfo: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
  tabInfo: {
    borderWidth: 1,
    display: 'flex',
    justifyContent: 'space-evenly',
    alignItems: 'center',
    width: '90%',
    alignItems: 'center',
    flexDirection: 'row',
    padding: 15,
  },
  info: {
    fontSize: 16,
    fontWeight: 'bold',
    marginBottom: 8,
    display: 'flex',
    flexDirection: 'column',
  },
});

export default DetailsPokemon;
