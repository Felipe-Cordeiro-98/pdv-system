import "./Product.css";
import lupa from "../../../public/products/lupa.svg";
import { useEffect, useState } from "react";
import api from "../../services/App";

export default function products() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await api.get("/products");
                setProducts(response.data);
            } catch (error) {
                console.error("Erro ao buscar os produtos:", error);
            }
        };

        fetchData();
    }, []);

    return (
        <main className="product-main">
            <div className="product-top">
                <div className="product-top-left">
                    <h2>Produto</h2>
                    <input type="text" placeholder="Buscar..." />
                    <img className="img" src={lupa} alt="lupa icon" />
                </div>
                <button className="add-product-button">+ Produto</button>
            </div>
            <div className="product-list">
                <table border="1px">
                    <thead>
                        <tr>
                            <th>Produto id</th>
                            <th>Nome</th>
                            <th>Quantidade</th>
                            <th>Preço</th>
                        </tr>
                    </thead>
                    <tbody>
                        {products.map((product) => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.name}</td>
                                <td>{product.stockQuantity}</td>
                                <td>{product.price}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <div className="product-list-pagination"></div>
        </main>
    );
}
