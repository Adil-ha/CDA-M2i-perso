import {Button, StyleSheet, Text, View} from 'react-native';
import React, {useEffect, useState} from 'react';
import Geolocation from '@react-native-community/geolocation';
import axios from 'axios';

// npm i @react-native-community/geolocation
// ajout de la ligne : <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
// dans le repertoire android/app/src/main/AndroidManifest.xml

export default function App() {
  const [latitude, setLatitude] = useState(null);
  const [longitude, setLongitude] = useState(null);
  const [localizedName, setLocalizedName] = useState(null); // Ajout du state localizedName

  useEffect(() => {
    Geolocation.requestAuthorization();
    Geolocation.getCurrentPosition(
      position => {
        setLatitude(position.coords.latitude);
        setLongitude(position.coords.longitude);
      },
      error => console.log(error),
      {enableHighAccuracy: true, timeout: 20000, maximumAge: 1000},
    );
  }, []);

  const handleLocalisation = () => {
    axios
      .post(
        `http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey=%09L5hJESVwQBdm0rvNd1lGG7LhqNhm8jCY&q=${latitude}%2C${longitude}`,
        {latitude: latitude, longitude: longitude},
      )
      .then(response => {
        setLocalizedName(response.data.LocalizedName); // Stockage de LocalizedName dans le state
        console.log(response.data.LocalizedName);
      })
      .catch(error => {
        console.error('Erreur : ', error);
      });
  };

  return (
    <View>
      <Button
        title="Obtenir information localisation"
        onPress={handleLocalisation}
      />
      <Text>Latitude : {latitude}</Text>
      <Text>Longitude : {longitude}</Text>
      <Text>LocalizedName : {localizedName}</Text> // Affichage de LocalizedName
    </View>
  );
}
