import React from 'react';
import {Modal, View, Text, Button} from 'react-native';

const DetailsArticle = ({item, onClose}) => {
  return (
    <Modal visible={true} animationType="slide">
      <View>
        <Text>ID: {item.id}</Text>
        <Text>Name: {item.text}</Text>
        <Button title="Close" onPress={onClose} />
      </View>
    </Modal>
  );
};

export default DetailsArticle;
