import React from 'react';
import "./styles/MapView.css";
import { GoogleMap, LoadScript, Marker, Circle } from '@react-google-maps/api';

function MapView(props) {

    const mapStyles = {        
        height: "100vh",
        width: "64.5%",
        float: "right"
    };

    return (
        <div className="MapView">
            <LoadScript
                googleMapsApiKey={process.env.REACT_APP_MAP_KEY}>
                <GoogleMap
                    mapContainerStyle={mapStyles}
                    zoom={12}
                    center={props.coords}
                >
                    <Marker position={props.coords}/>
                    <Circle
                        center={props.coords}
                        radius={props.radius}
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
