import React, {useState} from 'react';
import {Button, FlatList, StyleSheet, Text, View} from 'react-native';

const HomePage = ({navigation}) => {
  const listContact = [
    {
      lastname: 'Dupont',
      firstname: 'Michel',
      age: 40,
    },
    {
      lastname: 'Petit',
      firstname: 'Jean',
      age: 32,
    },
    {
      lastname: 'Jecplus',
      firstname: 'Pasdidee',
      age: 18,
    },
  ];

  const [contacts, setContacts] = useState(listContact);

  return (
    <View>
      <Text>HomePage</Text>
      <Text>Liste Contact</Text>
      <FlatList
        data={contacts}
        renderItem={({item}) => {
          return (
            <Button
              title={item.lastname}
              onPress={() => navigation.navigate('Contact', {contact: item})}
            />
          );
        }}
        keyExtractor={(item, index) => index.toString()}
      />
    </View>
  );
};

export default HomePage;
