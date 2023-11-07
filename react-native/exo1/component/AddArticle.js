import React, {useState} from 'react';
import {Button, FlatList, StyleSheet, Text, View} from 'react-native';
import CustomModal from './CustomModal';

export default function AddArticle() {
  const [modalVisible, setModalVisible] = useState(false);
  const [articles, setArticles] = useState([]);

  const openModal = () => {
    setModalVisible(true);
  };

  const closeModal = () => {
    setModalVisible(false);
  };

  const handleAddArticle = newArticle => {
    setArticles([...articles, newArticle]);
  };

  return (
    <View style={styles.container}>
      <Button title="AJOUTER ARTICLE" onPress={openModal} />
      <CustomModal
        visible={modalVisible}
        closeModal={closeModal}
        addArticle={handleAddArticle}
      />

      <View style={styles.articleList}>
        <Text style={styles.articleListTitle}></Text>
        {/* {articles.map((article, index) => (
          <Text key={index} style={styles.articleItem}>
            {article}
          </Text>
        ))} */}
        <FlatList
          data={articles}
          renderItem={itemData => {
            return (
              <View>
                <Text style={styles.articleItem}>{itemData.item.text}</Text>
              </View>
            );
          }}
          keyExtractor={(item, index) => {
            return index;
          }}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    margin: 20,
    flex: 1,
  },
  articleList: {},
  articleListTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  articleItem: {
    fontSize: 16,
    marginBottom: 5,
    color: 'black',
    backgroundColor: 'blueviolet',
    padding: 8,
    borderRadius: 5,
  },
  text: {
    color: 'black',
  },
});
