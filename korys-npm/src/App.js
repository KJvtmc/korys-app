
import './App.css';
// import  { useContext } from 'react';
// import ProductListContainer from './containers/ProductListContainer';
// import ServicesContext from './ServicesContext';
import Login from './components/Login';
// import ShowUser from './components/ShowUser';
// import { LoginContext } from './contexts/LoginContext';
import React, { useEffect, useReducer } from "react";
import apiEndpoint from "./components/endpoint";
import http from "./components/httpService";
import AuthContext from "./contexts/AuthContext";

import CommonErrorHandler from "./components/CommonErrorHandler"
import { Switch, Route, Redirect } from "react-router-dom";
import Admin from './pages/Admin';
import Product from './pages/Product';
import Registracija from './pages/Registracija';
// import {LoginContext} from './contexts/LoginContext';

var initState = {
  isAuthenticated: false,
  username: null,
  //role: null,
  error: null,
};

const reducer = (state, action) => {
  switch (action.type) {
    case "LOGIN":
      return {
        ...state,
        isAuthenticated: true,
        username: action.payload.username,
        //role: action.payload.role,
        error: null,
      };
    case "LOGOUT":
      return {
        ...state,
        isAuthenticated: false,
        username: null,
        //role: null,
        error: null,
      };
    case "ERROR":
      return {
        ...state,
        isAuthenticated: false,
        username: null,
        //role: null,
        error: action.payload,
      };
    default:
      return state;
  }
};

var NoMatch = (props) => {
  var goApp = () => props.history.push("/");
  return <div>Route did not match
    <button onClick={goApp}>Go Home</button></div>;
};



function App() {
  const [state, dispatch] = useReducer(reducer, initState);

  useEffect(() => {

    if (state.isAuthenticated === null) {
      http
        .get(`${apiEndpoint}/api/loggedUser`)
        .then((resp) => {
          dispatch({
            type: "LOGIN",
            //payload: { role: resp.data },
          });
        })
        .catch((error) => {
          const unexpectedError = error.response &&
            error.response.status >= 400 &&
            error.response.status < 500;

          if (!unexpectedError || (error.response && error.response.status === 404)) {
            dispatch({
              type: "ERROR",
            });
            return(<div className="modal" tabindex="-1">
              <div className="modal-dialog">
                <div className="modal-content">
                  <div className="modal-header">
                    <h5 className="modal-title">Įvyko klaida, puslapis nurodytu adresu nepasiekiamas</h5>
                    <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  </div>
                </div>
              </div>
            </div>)
            
          }
          else dispatch({
            type: "ERROR",
            payload: error.response.status,
          });
        });
    }
  }, [state.isAuthenticated]);

  if (state.isAuthenticated) {

    return (
      <AuthContext.Provider value={{ state, dispatch }}>
        <CommonErrorHandler>
          <div className="container-fluid px-0">
            <Switch>
              <Route exact path='/' component={App} />
              <Route path='/pages/Admin' component={Admin} />
              <Route path='/registracija' component={Registracija} />             <Route path='/:id' component={Product} />
              <Route path="*" component={NoMatch} />
              <Route component={NoMatch} />
            </Switch>
          </div>
        </CommonErrorHandler>
      </AuthContext.Provider>
    );

  } else if (state.isAuthenticated === false) {
    return (
      <div>
        <AuthContext.Provider value={{ state, dispatch }}>
          <Switch>
            <Route exact path="/login" component={Login} />
            <Route path="*">
              <Redirect to="/login" />
            </Route>
          </Switch>
        </AuthContext.Provider>
      </div>
    );
  }
  else return (<div>Loading page
  </div>)
}

export default App;

// function App() {
//    const { showusername, cart } = useContext(LoginContext);
//   return (
//     <div className="App">

//       <main>
// 	<div className="row">
//         <div className="col ">
//           {/* <LoginContext.Provider value={{username, setUsername, setShowusername}}> */}
//             {showusername ? <ShowUser /> : <Login />}
//           {/* </LoginContext.Provider> */}
//         </div>
//         </div>
//           <ProductListContainer />
//       </main>
//       {/* </LoginContext.Provider> */}
//     </div>
//   );
// }


//export default App;
