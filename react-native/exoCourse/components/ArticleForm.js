import React, {useState} from 'react';
import {StyleSheet, Text, View, TextInput, Image, Button} from 'react-native';
import {Article} from '../models/Article';

const ArticleForm = ({navigation, addElement}) => {
  const [articleName, setArticleName] = useState('');
  const [articlePrice, setArticlePrice] = useState('');

  const addElement = () => {
    const newArticle = new Article(articleName, articlePrice);
    addArticle(newArticle);
    setArticleName('');
    setArticlePrice('');
  };

  return (
    <View style={styles.container}>
      <Image
        source={require('./assets/caddie.png')}
        style={styles.image}
        resizeMode="contain"
      />
      <TextInput
        style={styles.textInput}
        placeholder="Article name"
        value={articleName}
        onChangeText={text => setArticleName(text)}
      />
      <TextInput
        style={styles.textInput}
        placeholder="Article Price"
        value={articlePrice}
        onChangeText={text => setArticlePrice(text)}
      />
      <View style={styles.buttonContainer}>
        <View style={styles.button}>
          <Button
            title="Add Article"
            onPress={() => {
              navigation.navigate('HomePage', {addElement});
            }}
          />
        </View>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  textInput: {
    borderWidth: 1,
    borderColor: '#cccccc',
    width: '70%',
    padding: 8,
    borderRadius: 12,
    marginBottom: 10,
  },
  buttonContainer: {
    marginTop: 16,
    flexDirection: 'row',
  },
  button: {
    width: '40%',
    marginHorizontal: 8,
  },
  image: {
    width: 100,
    height: 150,
  },
});

export default ArticleForm;
