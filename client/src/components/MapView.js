import React, {useState} from 'react';
import "./styles/MapView.css";
import { GoogleMap, LoadScript } from '@react-google-maps/api';
import {getCurrentCoords} from "../map/index"

function MapView() {

    const mapStyles = {        
        height: "100vh",
        width: "100%"
    };

    const [coords, setCoords] = useState({lat: null, long: null})
  
    getCurrentCoords(setCoords)
    
    console.log(coords)
    return (
        <div className="MapView">
          
        </div>
    )
}

export default MapView
