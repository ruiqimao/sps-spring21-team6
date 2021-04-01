import React, {useState} from 'react';
import "./styles/MapView.css";
import { GoogleMap, LoadScript, Marker, Circle } from '@react-google-maps/api';
import {getCurrentCoords} from "../map/"


function MapView() {

    const mapStyles = {        
        height: "100vh",
        width: "100%"
    };

    const [coords, setCoords] = useState({})
    const [radius, setRadius] = useState(3000)
  
    getCurrentCoords(setCoords)

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
