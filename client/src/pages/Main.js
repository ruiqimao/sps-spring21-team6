import React from 'react'
import SideView from "../components/SideView";
import MapView from "../components/MapView";

function Main() {
    return (
        
        <div className="row">
            <div className="col-sm-12 col-md-5">
                <SideView />
            </div>
            <div className="col-sm-12 col-md-7">
                <MapView />
            </div>
        </div>
    
    )
}

export default Main
