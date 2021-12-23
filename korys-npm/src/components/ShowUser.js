import React, { useContext } from 'react';
import { LoginContext } from '../contexts/LoginContext';

function ShowUser() {

    const { username } = useContext(LoginContext);
    return (
        <>
            <h4>Hello { username }</h4>
        </>
    )
}

export default ShowUser
