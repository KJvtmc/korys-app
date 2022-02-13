import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js';
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { Switch,  Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
// import { useParams, useLocation, useHistory, useRouteMatch } 
//         from 'react-router-dom';

// import { Helmet } from "react-helmet";


// const TITLE = 'My Page Title';

document.title =
  "Pavadinimas";

ReactDOM.render(
  <React.StrictMode>
      <BrowserRouter basename={process.env.PUBLIC_URL}>
        <Switch>
          <Route path="*" component={App} />
        </Switch>
      </BrowserRouter>
  </React.StrictMode>,
  document.getElementById("root")
);


// ReactDOM.render((
//   <div>
//     <BrowserRouter basename={process.env.PUBLIC_URL}>
//       <AppContainer>
//         <Switch>
//           <Route exact path='/' component={ App } />
//           <Route path='/pages/Admin' component={ Admin } />
//           <Route path='/registracija' component={ Registracija } />
//           <Route path='/:id'  component={ Product } />
//           <Route path="*" component={ NoMatch } />
//           <Route component={ NoMatch } />
//         </Switch>
//       </AppContainer>
//     </BrowserRouter>
//     {/* <Helmet>
//       <title>{TITLE}</title>
//     </Helmet> */}
//   </div>
// ), document.getElementById('root'));



// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
