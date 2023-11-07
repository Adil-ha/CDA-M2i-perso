import {StyleSheet, Text, View, Pressable, Button} from 'react-native';
import DetailsArticle from './DetailsArticle';
import React, {useState} from 'react';

export default function Article({item, onDelete}) {
  const [showDetails, setShowDetails] = useState(false);

  const handleDelete = () => {
    onDelete(item.id);
  };

  const handleDetails = () => {
    setShowDetails(true);
  };

  return (
    <Pressable>
      <View style={styles.articleItem}>
        <Text style={styles.articleText}>{item.text}</Text>
        <Button title="Delete" onPress={handleDelete} color="red"></Button>
        <Button title="Detail Article" onPress={handleDetails} color="blue" />
        {showDetails && (
          <DetailsArticle item={item} onClose={() => setShowDetails(false)} />
        )}
      </View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  articleItem: {
    margin: 8,
    padding: 8,
    borderRadius: 6,
    backgroundColor: '#5e0acc',
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'spaceBetween',
    alignItems: 'center',
  },
  articleText: {
    color: 'white',
  },
});
