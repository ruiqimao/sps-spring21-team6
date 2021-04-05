

const getCurrentCoords = (setState) => {

    const error = err => {
        console.warn(`ERROR(${err.code}): ${err.message}`);
    }

    const options = {
        enableHighAccuracy: true,
        timeout: 200,
        maximumAge: 0
    };
    

    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(pos => {

        let lat = pos.coords.latitude
        let lng = pos.coords.longitude

        setState({lat, lng})
        return

      }, error, options);


    } else {
      console.error("Your browser does not support Geolocation!");
    }
    
  }

  const getAddressData = async (lat, long) => {
    try{
      const res = await fetch(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${lat},${long}&sensor=true&key=${process.env.REACT_APP_MAP_KEY}`);
      const data = await res.json()
      const addressData = data.results[0].address_components
      const [address, street, city, county, state, country, zip] = addressData
      return {address, street, city, county, state, country, zip}
    } catch(err){
      console.log(err)
    }
  }


module.exports = {
    getCurrentCoords,
    getAddressData
}
