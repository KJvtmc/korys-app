import React from "react";
import UserComponent from "./UserComponent";

const UserListComponent = ({ users }) => {
    console.log("UserListComponent ");
    console.log(users);

    return (
        <table className="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">Firstname</th>
                    <th scope="col">Lastname</th>
                </tr>
            </thead>
            <tbody>
                {users.map((user) => (
                    <UserComponent key={(users.indexOf(user))} user={user} />
                ))}
            </tbody>
        </table>
    )

}
export default UserListComponent