import React from 'react';
import {StyleSheet, Text, View} from 'react-native';

const ArticleDetails = ({route}) => {
  const {article} = route.params;

  return (
    <View style={styles.container}>
      <Text>ID: {article.getId()}</Text>
      <Text>Name: {article.getName()}</Text>
      <Text>Price: {article.getPrice()}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default ArticleDetails;
