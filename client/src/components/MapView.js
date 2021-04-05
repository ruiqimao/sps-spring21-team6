import React, {useEffect, useState} from 'react';
import "./styles/MapView.css";
import { GoogleMap, LoadScript, Marker, Circle } from '@react-google-maps/api';
import {getCurrentCoords, getAddressData} from "../map/"


function MapView() {

    const mapStyles = {        
        height: "100vh",
        width: "64.5%",
        float: "right"
    };

    const [coords, setCoords] = useState({})
    const [radius, setRadius] = useState(3000)
    const [address, setAddress] = useState({})
  
    getCurrentCoords(setCoords)

    useEffect(() => { 
        getAddressData(coords.lat, coords.lng).then(data =>{
            setAddress(data)
        })
    }, [coords])
  
    
    console.log(coords)
    console.log(address.zip.long_name)
    return (
        <div className="MapView">
            <LoadScript
                googleMapsApiKey={process.env.REACT_APP_MAP_KEY}>
                <GoogleMap
                    mapContainerStyle={mapStyles}
                    zoom={13}
                    center={coords}
                >
                    <Marker position={coords}/>
                    <Circle
                        center={coords}
                        radius={radius}
                        options={{
                            strokeColor: "#ff0000"
                        }}
                    />
                </GoogleMap>
                
            </LoadScript>
        </div>
    )
}

export default MapView
