import React, { Component } from "react";
import ProductListComponent from "../components/ProductListComponent";
import axios from 'axios';
// axios.get('https://itpro2017.herokuapp.com/api/products')
// .then( (response) => {
// console.log(response);
// })
// .catch( (error) => {
// console.log(error);
// });


class ProductListContainer extends Component {
    constructor() {
        super();
        this.state = {
            products: [
                {
                    id: 0,
                    title: 'Vakcinacijos centras',
                    imageUrl: "https://miro.medium.com/max/880/0*H3jZONKqRuAAeHnG.jpg",
                    description: "Kraunasi",
                    vakcinos: [
                        {
                          pavadinimas: "Moderna (Spikevax)",
                          kiekis: 0,
                        },
                        {
                          pavadinimas: "Pfizer–BioNTech (Comirnaty)",
                          kiekis: 0,
                        },{
                          pavadinimas: "Oxford–AstraZeneca (Vaxzevria)",
                          kiekis: 0,
                        },{
                          pavadinimas: "Johnson & Johnson (Janssen)",
                          kiekis: 0,
                        },{
                          pavadinimas: "Pfizer–BioNTech (5-11 metų vaikams)",
                          kiekis: 0,
                        }
                    ],
                },
            ]
        };
        this.api = axios.create({
            baseURL: "http://localhost:8081/korys-war/vakcinacija/centrai/"
        });
    }

    componentDidMount() {
        const loadProducts = async () => {
            const response = await this.api.get("/");
            // console.log("state ");
            // console.log(response);
            const productsFromServer = response.data;
            // console.log("from service ");
            // console.log(productsFromServer);
            this.setState({ products: productsFromServer });
            // console.log("state ");
            // console.log(this.state.products);
        }
        setTimeout(loadProducts, 1000)
    }


    render() {
        return (
            <div className="container">
                <div className="row">
                        <ProductListComponent products={this.state.products} />
                </div>
            </div>
        );
    }
}
export default ProductListContainer