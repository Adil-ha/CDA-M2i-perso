import React, {useState} from 'react';
import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  FlatList,
  Button,
} from 'react-native';
import {Article} from '../models/Article';

const articlesDefault = [
  new Article('Article 1', 20),
  new Article('Article 2', 30),
];

const HomePage = ({navigation}) => {
  const [articles, setArticles] = useState(articlesDefault);

  function addArticle(article) {
    setArticles(articlesCurrent => [...articlesCurrent, article]);
  }

  return (
    <View style={styles.container}>
      <FlatList
        data={articles}
        renderItem={({item}) => {
          return (
            <Button
              title={item.getName()}
              onPress={() =>
                navigation.navigate('ArticleDetails', {article: item})
              }
            />
          );
        }}
        keyExtractor={item => item.getId().toString()}
      />

      <TouchableOpacity
        style={styles.addArticleButton}
        onPress={() => navigation.navigate('ArticleForm', {addArticle})}>
        <Text style={styles.addArticleText}>Add Article</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  button: {
    borderWidth: 1,
    borderColor: '#cccccc',
    width: '70%',
    padding: 8,
    borderRadius: 12,
    margin: 5,
    alignItems: 'center',
  },
  addArticleButton: {
    backgroundColor: 'blue',
    padding: 10,
    margin: 20,
    borderRadius: 8,
  },
  addArticleText: {
    color: 'white',
    textAlign: 'center',
  },
});

export default HomePage;
