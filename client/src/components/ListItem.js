import React from 'react';

function ListItem() {
    return (
        <div className="ListItem border bg-white px-4 py-3">
                <div className="mb-1">
                    <h5 className="card-title d-inline">Title</h5>
                    <h5 className="card-title d-inline float-right">Salary</h5>
                </div>
                
                <p className="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto omnis odit magnam, dolorem perspiciatis labore saepe, accusantium magni non ab qui. </p>
                <a className="btn btn-primary">Go to job page</a>
        </div>
    )
}

export default ListItem
