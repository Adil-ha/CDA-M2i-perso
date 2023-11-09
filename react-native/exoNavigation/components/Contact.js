import {StyleSheet, Text, View} from 'react-native';
import React from 'react';

const Contact = ({route}) => {
  const {contact} = route.params;

  return (
    <View>
      <Text>Detail Contact</Text>
      <Text>Nom : {contact.lastname}</Text>
      <Text>Prénom : {contact.firstname}</Text>
      <Text>Age : {contact.age}</Text>
    </View>
  );
};

export default Contact;
