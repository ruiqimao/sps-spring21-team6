
import {useState, useEffect} from 'react';

export const usePosition = () => {
  const [coords, setCoords] = useState({});
  const [error, setError] = useState(null);
  
  const onSuccess = ({coords}) => {
    setCoords({
      lat: coords.latitude,
      lng: coords.longitude,
    });
  };
  const onError = (error) => {
    setError(error.message);
  };
  useEffect(() => {
    const geo = navigator.geolocation;
    if (!geo) {
      setError('Geolocation is not supported');
      return;
    }
    let watcher = geo.watchPosition(onSuccess, onError);

    return () => geo.clearWatch(watcher);
  }, []);
  return {coords: {...coords}, setCoords, error};
}

export const getAddressData = async (lat, lng) => {
  try{
    const res = await fetch(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${lat},${lng}&sensor=true&key=${process.env.REACT_APP_MAP_KEY}`);
    const data = await res.json()
    const addressData = data.results[0].address_components
    console.log(addressData)
    const [address, street, city, county, state, country, zip] = addressData
    return {address, street, city, county, state, country, zip}
    
  } catch(err){
    console.log(err)
  }
}


