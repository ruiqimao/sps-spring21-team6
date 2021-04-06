import React from 'react';
import ListItem from './ListItem';
import "./styles/SideView.css";

function SideView(props) {
    console.log(props.gigs)
    return (
        <div className="SideView">
            {props.gigs.map(gig => <ListItem {...gig} />)}
        </div>   
    )
}

export default SideView
