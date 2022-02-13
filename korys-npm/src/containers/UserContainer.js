
import UserListComponent from "../components/UserListComponent";
import React, { Component } from "react";
import axios from 'axios';

// axios.get('http://localhost:8080/api/users')
//         .then( (response) => {
//         console.log(response);
//         return response;
//         })
//         .catch( (error) => {
//         console.log(error);
//         });

class UserContainer extends Component {

    
    constructor() {
        super();
        this.state = {
            users: [
                {
                    id: null,
                    firstName: "loading from DB",
                    lastName: "loading from DB",
                }
            ]
        };
        this.api = axios.create({
            baseURL: "http://localhost:8081/korys-war/api/users"
        });
    }

    componentDidMount() {
        const loadUsers = async () => {
            try{
            const response = await this.api.get("/");
            // console.log("state ");
            // console.log(response);
            const usersFromServer = response.data;
            // console.log("from service ");
            // console.log(usersFromServer);
            this.setState({ users: usersFromServer });
            // console.log("state ");
            // console.log(this.state.users);
        }catch(error){
            console.log(error);
        }
        }
        setTimeout(loadUsers, 1000)
    }

    render() {
        if (this.state.users !== null) {
            return (
                <div className="container-flexible">
                    <div className="row">
                        <div className="col">
                            <UserListComponent users={this.state.users} />
                        </div>
                    </div>
                </div >
            );
        }
        else {
            return (
                <div className="container-flexible">
                    <div className="row">
                        <h1>No registered users found</h1>
                    </div>
                </div>
            )
        }
    }
}
export default UserContainer;
