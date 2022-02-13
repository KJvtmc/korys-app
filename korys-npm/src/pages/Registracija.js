import { Form, Button } from "react-bootstrap";
import {  createRef, useContext } from 'react';
import { LoginContext } from '../contexts/LoginContext';
import React from 'react';
import UserContainer from '../containers/UserContainer';
import axios from 'axios';

// forma naudojantis funkcijomis, ref, hooks
export default function AddProduct() {

    //type of data [stateData, stateUpdateFunction] = useState(initialData)
    //let initialValue = [];
    const { productdetails } = useContext(LoginContext);
    // const [products, setProduct] = useState(initialValue);
    const formData = createRef();
    let api = axios.create({
        baseURL: "http://localhost:8081/korys-war/api/users"
    });
    //addproduct handler
    const addProduct = (e) => {
        e.preventDefault();
        // kitas būdas paimti values iš formos
        // const formData = e.target;
        // const pacientas = {
        //     firstName: formData.firstName.value,
        //     lastName: formData.lastName.value,
        //     id: formData.id.value
        // }

        //  būdas paimti values iš formos su react metodu createRef
        const pacientas = {

            id: Number(formData.current.id.value),
            firstName: formData.current.firstName.value,
            lastName: formData.current.lastName.value
            
        }
        // add a new product inside products array
        console.log(pacientas);
        //api.put(url:"",data:pacientas,);
        // setProduct([...products, pacientas]);
    }
    // // increment Quantity by 1
    // const incrementQuantity = (e) =>{
    //     const currentIndex = e.target.value;
    //     products[currentIndex].id= products[currentIndex].id+1;
    //     setProduct([...products])
    // }

    // // decrement Quantity by 1
    // const decrementQuantity = (e) =>{
    //     const currentIndex = e.target.value;
    //     if (products[currentIndex].id>0){
    //     products[currentIndex].id= +products[currentIndex].id-1;
    //     setProduct([...products])
    //     }
    // }

    return (
        <div>
            <div>
                <h1> Registracija į {productdetails.pavadinimas}</h1>
            </div>

            <Form onSubmit={addProduct} ref={formData}>
                <Form.Group className="mb-3" controlId="formFirstName">
                    <Form.Label>Vardas</Form.Label>
                    <Form.Control type="text" name="firstName" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLastName">
                    <Form.Label>Pavardė</Form.Label>
                    <Form.Control type="text" name="lastName" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formId">
                    <Form.Label>Asmens kodas</Form.Label>
                    <Form.Control type="number" min="300000000" max="499999999" name="id" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Pasirinkite vakciną</Form.Label>
                    <Form.Select >
                        {productdetails.vakcinos.map(element =>
                            <option key={element.pavadinimas} >{element.pavadinimas} Turimas kiekis:{element.kiekis}</option>
                        )}
                        {/* <option>{productdetails.va}</option>
                            <option>Pfizer–BioNTech (Comirnaty): {productdetails.comirnaty}</option>
                            <option>Oxford–AstraZeneca (Vaxzevria): {productdetails.vaxzevria}</option>
                            <option>Johnson & Johnson (Janssen): {productdetails.janssen}</option>
                            <option>Pfizer–BioNTech (5-11 metų vaikams): {productdetails.biontech}</option> */}
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Pasirinkite kabiną</Form.Label>
                    <Form.Select >
                        {productdetails.kabinos.map(element =>
                            <option key={element.kabinosid} >{element.kabinosid} Statusas:{element.statusas ? "laisva" : "užimta"}</option>
                        )}
                        {/* <option>{productdetails.va}</option>
                            <option>Pfizer–BioNTech (Comirnaty): {productdetails.comirnaty}</option>
                            <option>Oxford–AstraZeneca (Vaxzevria): {productdetails.vaxzevria}</option>
                            <option>Johnson & Johnson (Janssen): {productdetails.janssen}</option>
                            <option>Pfizer–BioNTech (5-11 metų vaikams): {productdetails.biontech}</option> */}
                    </Form.Select>
                </Form.Group>
                <Button variant="primary" type="submit" onClick={addProduct}>
                    Registruoti
                </Button>

            </Form>
            <h3>Registruoti pacientai</h3>
            <UserContainer />

        </div>
    )
}
