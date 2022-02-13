import { Form, Button, Table, Modal } from "react-bootstrap";
import { Link } from 'react-router-dom';
import React, { useContext, useState } from 'react';
import { LoginContext } from '../contexts/LoginContext';
// import Login from '../components/Login';
// import ShowUser from '../components/ShowUser';

function Product() {
    const [show, setShow] = useState(false);
    const [show2, setShow2] = useState(false);
    const [kabina, setKabina] = useState({
        nr:0,
        laisva:false,
    });
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleClose2 = () => setShow2(false);
    const handleShow2 = () => setShow2(true);
   

    // const { cart, setCart, productdetails, showusername} = useContext(LoginContext);
    const { productdetails, setProductdetails } = useContext(LoginContext);
    

    const handleClick = (element) => {

        handleShow();
        setKabina(element
            // nr:element.nr,
            // laisva:!element.laisva
        );
        console.log(element)
    }

    const handleClick2 = (element) => {

        handleShow2();
        setKabina(element
            // nr:element.nr,
            // laisva:!element.laisva
        );
        console.log(element)
    }

    const keistiStatusa = () => {
        console.log("hghg");
        var newProduct=productdetails;
        console.log(newProduct);
        var kabinos = newProduct.kabinos;
        console.log(kabina);
        var index =kabinos.indexOf(kabina);
        console.log(index);
        if (index !==-1){
            kabinos[index]={
                id: kabina.id,
                centras: null,
                kabinosId: kabina.kabinosId,
                statusas: !kabina.statusas,
            }
        }
        console.log(kabinos);
        setProductdetails(newProduct);
        console.log(productdetails);
        handleClose();
    }

    const naikintiKabina = () => {
        console.log("naikinimas");
        var newProduct=productdetails;
        console.log(newProduct);
        var kabinos = newProduct.kabinos;
        console.log(kabina);
        var index =kabinos.indexOf(kabina);
        console.log(index);
        if (index !==-1){
            kabinos.splice(index, 1)
        }
        console.log(kabinos);
        setProductdetails(newProduct);
        console.log(productdetails);
        handleClose2();
    }

    return (
        <div>

            <div className="card" style={{ width: "18 rem" }}>
                <h1>{productdetails.pavadinimas} </h1>

                <img src={productdetails.imgNuoroda} className="card-img-top" alt="item"></img>
                <div className="card-body ">
                    <h5 className="card-title">{productdetails.pavadinimas}</h5>
                    <p className="card-text">{productdetails.aprasymas}</p>
                    <p className="card-text">Centro vieta: {productdetails.vieta} </p>
                    <Link to='/pages/Admin' >
                        <button className="btn btn-primary" >Pakeisti vietą</button>
                    </Link>
                    <p className="card-text">Turimos vakcinos: </p>
                    <Table striped bordered hover variant="dark">
                        <thead>
                            <tr>
                                <th>Vakcina</th>
                                <th>Kiekis</th>

                                {/* <th>-</th> */}
                            </tr>
                        </thead>
                        <tbody>
                            {
                                productdetails.vakcinos.map(element => {
                                    // this.state.products.map((item, index) => {
                                        
                                    return (
                                        <tr key={element.pavadinimas}>
                                            <td>{element.pavadinimas}</td>
                                            <th>{element.kiekis}</th>
                                        </tr>
                                    )
                                })
                            }
                        </tbody>
                    </Table>
                    <p className="card-text">Kabinos: </p>
                    <Table striped bordered hover variant="dark">
                        <thead>
                            <tr>
                                <th>Kabinos nr.</th>
                                <th>Statusas</th>
                                <th>Pakeisti statusą</th>
                                <th>Pašalinti</th>

                                {/* <th>-</th> */}
                            </tr>
                        </thead>
                        <tbody>
                            {
                                productdetails.kabinos.map(element => {
                                    // this.state.products.map((item, index) => {
                                        
                                    return (
                                        <tr key={element.kabinosId}>
                                            <td>{element.kabinosId}</td>
                                            <th>{element.statusas ? "Laisva" : "Užimta"}</th>
                                            <td>
                                                <Button variant="danger" onClick={()=>handleClick(element)}
                                                >Pakeisti statusą</Button>
                                            </td>
                                            <td>
                                                <Button variant="danger" onClick={()=>handleClick2(element)}
                                                >-</Button>
                                            </td>
                                        </tr>
                                    )
                                })
                            }
                        </tbody>
                    </Table>
                    <Modal show={show} onHide={handleClose}>
                        <Modal.Header closeButton>
                            <Modal.Title>Įspėjimas</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>Ar tikrai norite pakeisti kabinos statusą?</Modal.Body>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={keistiStatusa}>
                                Keisti
                            </Button>
                            <Button variant="primary" onClick={handleClose}>
                                Nekeisti
                            </Button>
                        </Modal.Footer>
                    </Modal>
                    <Modal show={show2} onHide={handleClose2}>
                        <Modal.Header closeButton>
                            <Modal.Title>Įspėjimas</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>Ar tikrai norite panaikinti kabiną?</Modal.Body>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={naikintiKabina}>
                                Naikinti
                            </Button>
                            <Button variant="primary" onClick={handleClose2}>
                                Nenaikinti
                            </Button>
                        </Modal.Footer>
                    </Modal>
                    <Form  >
                        <Form.Group className="mb-3" controlId="formBasicProductName">
                            <Form.Label>Kabinos nr.</Form.Label>
                            <Form.Control type="number" name="productName" />
                        </Form.Group>

                        <Button className="mb-3" variant="primary" type="submit">
                            Pridėti į sąrašą
                        </Button>
                    </Form>
                    <Link to={`/registracija`} >
                        <button className="btn btn-primary" onClick={() => setProductdetails(productdetails)} >Registruoti pacientą</button>
                    </Link>
                    <Link to='/' >
                        <button className="btn btn-primary"onClick={() => setProductdetails(productdetails)} >Grįžti</button>
                    </Link>
                </div>
            </div>
        </div>
    )
}
export default Product;