import React, {useEffect, useState} from 'react';
import SideView from "../components/SideView";
import MapView from "../components/MapView";
import {getCurrentCoords, getAddressData} from "../map/"

function Main() {

    const [coords, setCoords] = useState({})
    const [radius, setRadius] = useState(3000)
    const [gigs, setGigs] = useState([])
  
    getCurrentCoords(setCoords)

    useEffect(() => { 
        getAddressData(coords.lat, coords.lng).then(data =>{
            fetch("http://localhost:8080/get")
            .then(res => res.json())
            .then(gigs => setGigs([...gigs.data.subdata]))
            .catch(err => console.log(err))
        })
    }, [coords])

    
    
    return (
        
        <div className="row">
            
            <SideView gigs={gigs}/>
        
            <MapView coords={coords} radius={radius}/>
            
        </div>
    
    )
}

export default Main
