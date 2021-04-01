import React, {useState} from 'react';
import "./styles/MapView.css";
import { GoogleMap, LoadScript } from '@react-google-maps/api';
import {getCurrentCoords} from "../map/"


function MapView() {

    const mapStyles = {        
        height: "100vh",
        width: "100%"
    };

    const [coords, setCoords] = useState({})
  
    getCurrentCoords(setCoords)

    return (
        <div className="MapView">
            <LoadScript
                googleMapsApiKey={process.env.REACT_APP_MAP_KEY}>
                <GoogleMap
                mapContainerStyle={mapStyles}
                zoom={13}
                center={coords}
                
                />
            </LoadScript>
        </div>
    )
}

export default MapView
