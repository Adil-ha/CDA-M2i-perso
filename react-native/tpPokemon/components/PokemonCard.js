import React from 'react';
import {View, Text, Image, StyleSheet, Pressable} from 'react-native';
import {useNavigation} from '@react-navigation/native';

const PokemonCard = ({name, categories, imageUrl, backgroundColor}) => {
  const navigation = useNavigation();
  const onPress = () => {
    navigation.navigate('DetailsPokemon', {name, backgroundColor});
  };
  return (
    <Pressable onPress={onPress}>
      <View style={[styles.card, {backgroundColor}]}>
        <View>
          <Text style={styles.name}>{name}</Text>
          <View style={styles.categoriesContainer}>
            {categories.map((category, index) => (
              <Text key={index} style={styles.categoryText}>
                {category}
              </Text>
            ))}
          </View>
        </View>
        <Image source={{uri: imageUrl}} style={styles.image} />
      </View>
    </Pressable>
  );
};

const styles = StyleSheet.create({
  card: {
    display: 'flex',
    flexDirection: 'row',
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 8,
    padding: 10,
    marginBottom: 10,
    borderRadius: 15,
    width: 180,
    height: 100,
  },
  name: {
    color: 'white',
  },
  image: {
    width: 100,
    height: 100,
    marginBottom: 8,
  },
  categoriesContainer: {
    flexDirection: 'column',
    marginTop: 8,
  },
  categoryText: {
    marginRight: 8,
    color: 'white',
    backgroundColor: 'white',
    borderRadius: 5,
    opacity: 0.2,
    marginBottom: 3,
  },
});

export default PokemonCard;
