import { Form, Button, Table } from "react-bootstrap";
import { useState, createRef } from 'react';
import React from 'react';

// forma naudojantis funkcijomis, ref, hooks
export default function AddProduct() {

    //type of data [stateData, stateUpdateFunction] = useState(initialData)
    let initialValue = [];
    const [products, setProduct] = useState(initialValue);
    const formData = createRef();
    //addproduct handler
    const addProduct = (e) => {
        e.preventDefault();
        // kitas būdas paimti values iš formos
        // const formData = e.target;
        // const newProduct = {
        //     productName: formData.productName.value,
        //     productPrice: formData.productPrice.value,
        //     productQuantity: formData.productQuantity.value
        // }

        //  būdas paimti values iš formos su react metodu createRef
        const newProduct = {
            productName: formData.current.productName.value,
            productPrice: formData.current.productPrice.value,
            productQuantity: Number(formData.current.productQuantity.value)
        }
        // add a new product inside products array
        setProduct([...products, newProduct]);
    }
    // // increment Quantity by 1
    // const incrementQuantity = (e) =>{
    //     const currentIndex = e.target.value;
    //     products[currentIndex].productQuantity= products[currentIndex].productQuantity+1;
    //     setProduct([...products])
    // }

    // // decrement Quantity by 1
    // const decrementQuantity = (e) =>{
    //     const currentIndex = e.target.value;
    //     if (products[currentIndex].productQuantity>0){
    //     products[currentIndex].productQuantity= +products[currentIndex].productQuantity-1;
    //     setProduct([...products])
    //     }
    // }

    return (
        <div>
            <Form onSubmit={addProduct} ref={formData}>
                <Form.Group className="mb-3" controlId="formBasicProductName">
                    <Form.Label>Vardas</Form.Label>
                    <Form.Control type="text"  name="productName" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicPrice">
                    <Form.Label>Pavardė</Form.Label>
                    <Form.Control type="text" name="productPrice" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicQuantity">
                    <Form.Label>Asmens kodas</Form.Label>
                    <Form.Control type="number" min="8" max="8"  name="productQuantity" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Registruoti
                </Button>
            </Form>
            
        </div>
    )
}