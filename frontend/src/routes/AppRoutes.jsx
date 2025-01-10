import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "../pages/Home";
import Product from "../pages/Product";
import Layout from "../components/Layout";

export default function AppRoutes() {
    return (
        <Router>
            <Layout>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/products" element={<Product />} />
                </Routes>
            </Layout>
        </Router>
    );
}
