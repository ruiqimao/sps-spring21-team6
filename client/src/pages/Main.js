import React, {useEffect, useState} from 'react';
import SideView from "../components/SideView";
import MapView from "../components/MapView";
import {usePosition, getAddressData} from "../map/"

function Main() {

    const {coords, setCoords, err} = usePosition()
    const [radius, setRadius] = useState(8050)
    const [gigs, setGigs] = useState([])

    useEffect(() => { 
        async function fetchGigs(){
            try{
                const address = await getAddressData(coords.lat, coords.lng);

                const url = process.env.REACT_APP_SERVLET_URL || "http://localhost:8080";
                const servletRes = await fetch(`${url}/get?zip=${address.zip.long_name}&rad=5`);
                const gigs = await servletRes.json();
                setGigs(gigs.data.subdata || []);
            } catch(err){
                console.error(err);
            }
            
        }
        
        if(gigs.length > 0) return;
        fetchGigs();

    }, [coords, gigs])

    
    return (
        
        <div className="row">
            
            <SideView gigs={gigs}/>
        
            <MapView coords={coords} radius={radius}/>
            
        </div>
    
    )
}

export default Main
