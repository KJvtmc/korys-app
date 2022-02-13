import React from "react";

const UserComponent = props => {
    console.log('in user component ');
    console.log(props);
    const { id, firstName, lastName } = props.user;
    console.log(id);
    return (
        <tr>
            <th scope="row"></th>
            <td >{id}</td>
            <td > {firstName}</td>
            <td >{lastName}</td>
            
        </tr>
    )
}
export default UserComponent;