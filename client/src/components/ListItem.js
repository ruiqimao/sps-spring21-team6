import React from 'react';

function ListItem(props) {
    const {name, description, salary, location, url} = props
    return (
        <div className="ListItem border bg-white px-4 py-3">
                <div className="mb-1">
                    <h5 className="card-title d-inline">{name}</h5>
                    <br/>
                    <h6 className="card-title d-inline">{location}</h6>
                    <span className="small d-inline float-right">{salary}</span>
                </div>
                
                <p className="card-text">{description}</p>
                <a href={url} rel="noreferrer" target="_blank" className="btn btn-primary">Go to job page</a>
        </div>
    )
}

export default ListItem
