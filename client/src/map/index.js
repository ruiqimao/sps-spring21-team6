

const getCurrentCoords = (setState) => {

    const error = err => {
        console.warn(`ERROR(${err.code}): ${err.message}`);
    }

    const options = {
        enableHighAccuracy: true,
        timeout: 1000,
        maximumAge: 0
    };
    

    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(pos => {

        let lat = pos.coords.latitude
        let lng = pos.coords.longitude

        setState({lat, lng})

      }, error, options);


    } else {
      console.error("Your browser does not support Geolocation!");
    }
    
  }


module.exports = {
    getCurrentCoords
}
