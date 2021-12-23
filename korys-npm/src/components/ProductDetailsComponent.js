import React, { useContext } from 'react';
import {LoginContext} from '../contexts/LoginContext';
import {  Link } from 'react-router-dom';


function ProductDetailsComponent (props) {
    
    // const { cart, setCart, setProductdetails } = useContext(LoginContext);
    const { setProductdetails } = useContext(LoginContext);

    var needsDefaultImage = props.product.imageUrl!==null?false:true;
    var needsDefaultDescription = props.product.description!==""?false:true;
    return (
        <div className="card" style={{width: "18 rem"}}>
            <img src={(needsDefaultImage)?props.product.imageUrl:"https://miro.medium.com/max/880/0*H3jZONKqRuAAeHnG.jpg"} className="card-img-top" alt="item"></img>
            <div className="card-body ">
                <h5 className="card-title">{props.product.title}</h5>
                <p className="card-text">{(needsDefaultDescription)?props.product.description:"Description is comming soon"}</p>
                <p className="card-text">Turimos vakcinos:</p>
                <p className="card-text">Bendras vakcinų kiekis:</p>
                <Link to={`/registracija`} >
                <button className="btn btn-primary" onClick={()=>setProductdetails(props.product)} >Registruoti pacientą</button>
                </Link>
                <Link to={`/${props.id}`} >
                <button className="btn btn-primary" onClick={()=>setProductdetails(props.product)}>Daugiau</button>
                </Link>
            </div>
        </div>
    )
}
export default ProductDetailsComponent;

