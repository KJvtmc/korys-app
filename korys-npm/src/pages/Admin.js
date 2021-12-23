import React, {Component} from 'react';
import UserContainer from '../containers/UserContainer';
import AddProductClass from '../components/AddProductClass';

class Admin extends Component {
    render() {
        return (
            <div >
                <header className="px-3 text-center">
                    <h2>Puslapio administravimas   </h2>
                </header>
                <main className="px-3">
                    <h3>Vakcinacijos centrai</h3>
                    <AddProductClass />
                    <h3>Registruoti pacientai</h3>
                    <UserContainer />
                </main>
            </div>
        );
    }
}


export default Admin;