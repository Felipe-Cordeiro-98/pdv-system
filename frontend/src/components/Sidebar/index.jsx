import "./SideBar.css";
import { Link } from "react-router-dom";
import products from "../../../public/sidebar/products.svg";
import sale from "../../../public/sidebar/sale.svg";
import report from "../../../public/sidebar/report.svg";
import gear from "../../../public/sidebar/gear.svg";

export default function Sidebar() {
    return (
        <aside className="sidebar-aside">
            <div className="card-link">
                <Link className="sidebar-link" to="/"><img src={sale} alt="img sale" />Venda</Link>
                <Link className="sidebar-link" to="/products"><img src={products} alt="img products" />Produtos</Link>
                <Link className="sidebar-link" to="/reports"><img src={report} alt="img report" />Relatórios</Link>
            </div>
            <div className="card-link">
                <Link className="sidebar-link"><img src={gear} alt="img gear" />Configurações</Link>
            </div>
        </aside>
    );
}