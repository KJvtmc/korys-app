
import {  Link } from 'react-router-dom';
import React, { useContext } from 'react';
import {LoginContext} from '../contexts/LoginContext';
// import Login from '../components/Login';
// import ShowUser from '../components/ShowUser';

function Product () {

    // const { cart, setCart, productdetails, showusername} = useContext(LoginContext);
    const { productdetails} = useContext(LoginContext);
    var needsDefaultImage = productdetails.imageUrl!==null?false:true;
    var needsDefaultDescription = productdetails.description!==""?false:true;
    

    return (
        <div>
        
        <div className="card" style={{width: "18 rem"}}>
            <h1>item {productdetails.title} </h1>
            
            <img src={(needsDefaultImage)?productdetails.imageUrl:"https://miro.medium.com/max/880/0*H3jZONKqRuAAeHnG.jpg"} className="card-img-top" alt="item"></img>
            <div className="card-body ">
                <h5 className="card-title">{productdetails.title}</h5>
                <p className="card-text">{(needsDefaultDescription)?productdetails.description:"Aprašymas kraunamas"}</p>
                <p className="card-text">Turimos vakcinos: </p>
            
                <button className="btn btn-primary" >Registruoti pacientą</button>
                <Link to='/' >
                <button className="btn btn-primary" >Grįžti</button>
                </Link>
            </div>
        </div>
        </div>
    )
}
export default Product;