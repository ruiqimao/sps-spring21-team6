import React, {useEffect, useState} from 'react';
import SideView from "../components/SideView";
import MapView from "../components/MapView";
import {usePosition, getAddressData} from "../map/"

function Main() {

    const {coords, setCoords, err} = usePosition()
    const [radius, setRadius] = useState(8046.72)
    const [gigs, setGigs] = useState([])

    useEffect(() => { 
        if(gigs.length > 0) return;
        getAddressData(coords.lat, coords.lng)
        .then(address => fetch(`http://localhost:8080/get?zip=${address.zip.long_name}&rad=5`))
        .then(res => res.json())
        .then(gigs => setGigs(gigs.data.subdata))
        .catch(err => console.log(err))
   
    }, [coords])

    
    return (
        
        <div className="row">
            
            <SideView gigs={gigs}/>
        
            <MapView coords={coords} radius={radius}/>
            
        </div>
    
    )
}

export default Main
