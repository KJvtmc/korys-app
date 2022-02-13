import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js';
import React, {useState} from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { Switch,  Route } from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';
// import { useParams, useLocation, useHistory, useRouteMatch } 
//         from 'react-router-dom';
import Admin from './pages/Admin';
// import { Helmet } from "react-helmet";
import Product from './pages/Product';
import Registracija from './pages/Registracija';
import {LoginContext} from './contexts/LoginContext';

// const TITLE = 'My Page Title';



var NoMatch = (props) => {
  var goApp = () => props.history.push("/");
  return <div>Route did not match
    <button onClick={goApp}>Go Home</button></div>;
};

// var DemonstruotiNavigacija = () => {
//   let location = useLocation();
//   let history = useHistory();
//   let goHome = () => history.push("/");
//   let params = useParams();
//   let match = useRouteMatch();
//   let { id } = useParams(); // arba match.params
//   return (
//     <div>
//       At route: {location.pathname} (ID: {id})
//       <button onClick={goHome}>Go Home</button>
//       <pre>
//         {JSON.stringify(history, null, 2)}<br />
//         {JSON.stringify(location, null, 2)}<br />
//         {JSON.stringify(match, null, 2)}<br />
//         {JSON.stringify(params, null, 2)}
//       </pre>
//     </div>
//   );
// };

var AppContainer = (props) => {
  // const [showusername, setShowusername] = useState(false);
  // const [username, setUsername] = useState("");
  // const [cart, setCart] = useState(0);
  
  const [productdetails, setProductdetails] = useState({
    id: 0,
    pavadinimas: 'Vakcinacijos centras',
    imgNuoroda: "loading.jpg",
    aprasymas: "Kraunasi",
    vieta: "default",
    kabinos: [
      {
        id: 200000001,
        centras: null,
        kabinosId: 1,
        statusas: true,
      },
      {
        id: 200000001,
        centras: null,
        kabinosId: 3,
        statusas: false,
      },
      {
        id: 200000001,
        centras: null,
        kabinosId: 2,
        statusas: true,
      }
    ],
    vakcinos: [
      {
        partijosId: 300001 ,
        centras: null,
        gamintojas:"Moderna",
        pavadinimas:"Moderna (Spikevax)",
        kiekis: 1,
      }
    ]
});
  return (
  <div>
    <LoginContext.Provider value={{productdetails, setProductdetails}}>
    <div>
      <nav className="navbar navbar-light bg-light">
        <div className="container-fltuid align-start">
          <Link className="px-3" to='/'> Vakcinacijos centrai </Link> 
          <Link className="px-3" to='/pages/Admin'> Centrų sąrašo tvarkymas </Link>
        </div>
      </nav>
    </div>
    {props.children}
    </LoginContext.Provider>
  </div>);
};

ReactDOM.render((
  <div>
    <BrowserRouter basename={process.env.PUBLIC_URL}>
      <AppContainer>
        <Switch>
          <Route exact path='/' component={ App } />
          <Route path='/pages/Admin' component={ Admin } />
          <Route path='/registracija' component={ Registracija } />
          <Route path='/:id'  component={ Product } />
          <Route path="*" component={ NoMatch } />
          <Route component={ NoMatch } />
        </Switch>
      </AppContainer>
    </BrowserRouter>
    {/* <Helmet>
      <title>{TITLE}</title>
    </Helmet> */}
  </div>
), document.getElementById('root'));



// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
