import React from "react";

const UserComponent = props => {
    console.log('in user component ');
    console.log(props);
    const { userName, firstName, lastName } = props.user;
    console.log(userName);
    return (
        <tr>
            <th scope="row"></th>
            <td >{userName}</td>
            <td > {firstName}</td>
            <td >{lastName}</td>
            
        </tr>
    )
}
export default UserComponent;