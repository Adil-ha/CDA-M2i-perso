import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import HomePage from './components/HomePage';
import ArticleDetails from './components/ArticleDetails';
import ArticleForm from './components/ArticleForm';

const Stack = createNativeStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="HomePage">
        <Stack.Screen
          name="HomePage"
          component={HomePage}
          options={{title: 'Accueil'}}
        />
        <Stack.Screen name="ArticleForm" component={ArticleForm} />
        <Stack.Screen name="ArticleDetails" component={ArticleDetails} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
