import React, {useEffect} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {fetchAllPokemons} from '../store/data/pokemonSlice';
import {StyleSheet, View, FlatList, Text} from 'react-native';
import PokemonCard from './PokemonCard';

const getTypeColor = type => {
  switch (type) {
    case 'bug':
      return 'green';
    case 'flying':
      return 'purple';
    case 'water':
      return 'blue';
    case 'fire':
      return 'orange';
    case 'ground':
      return 'brown';
    case 'electric':
      return '#F8D030';
    case 'fairy':
      return 'pink';
    case 'fighting':
      return 'red';
    default:
      return 'gray';
  }
};

const PokemonsLists = () => {
  const dispatch = useDispatch();
  const pokemons = useSelector(state => state.pokemon.pokemons);

  useEffect(() => {
    dispatch(fetchAllPokemons());
  }, [dispatch]);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Pokemons</Text>
      {pokemons.length === 0 ? (
        <Text>Loading...</Text>
      ) : (
        <FlatList
          numColumns={2}
          data={pokemons}
          keyExtractor={item => item.name}
          renderItem={({item}) => (
            <PokemonCard
              name={item.name}
              categories={item.types.map(type => type.type.name)}
              imageUrl={item.sprites?.front_default || ''}
              backgroundColor={getTypeColor(item.types[0].type.name)}
            />
          )}
        />
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  title: {
    color: 'black',
    fontSize: 36,
    fontWeight: 'bold',
  },
});

export default PokemonsLists;
