import {Button, Modal, TextInput, View, StyleSheet} from 'react-native';
import {useState} from 'react';

export default function CustomModal({visible, closeModal, addArticle}) {
  const [textInput, setTextInput] = useState('');

  function handleTextInput(enteredText) {
    setTextInput(enteredText);
  }

  function handleAddArticle() {
    addArticle(textInput);
    setTextInput('');
    closeModal();
  }

  return (
    <Modal visible={visible} onRequestClose={closeModal} transparent={true}>
      <View style={{flex: 1, width: 500, height: 500}}>
        <View style={styles.container}>
          <TextInput
            onChangeText={handleTextInput}
            value={textInput}
            placeholder="Enter article"
            style={styles.input}
          />
          <View style={{flexDirection: 'row', justifyContent: 'space-around'}}>
            <Button title="ADD ARTICLE" onPress={handleAddArticle} />
            <Button title="CANCEL" onPress={closeModal} />
          </View>
        </View>
      </View>
    </Modal>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: 'white',
    padding: 20,
    borderRadius: 10,
    width: '80%',
    height: '100%',
  },
  input: {
    borderColor: 'gray',
    borderWidth: 1,
    marginBottom: 20,
    paddingHorizontal: 10,
  },
});
