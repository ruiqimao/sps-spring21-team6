const options = {
    enableHighAccuracy: true,
    timeout: 5000,
    maximumAge: 0
};

const error = err => {
    console.warn(`ERROR(${err.code}): ${err.message}`);
}

const getLocation = pos => {
    const {latitude, longitude} = pos.coords
    return {latitude, longitude}
}

navigator.geolocation.getCurrentPosition(getLocation, error, options);

module.exports = {
    getLocation
}
