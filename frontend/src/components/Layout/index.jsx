import Sidebar from "../Sidebar";
import Header from "../Header";

import "./Layout.css";

const Layout = ({ children }) => {
    return (
        <div className="container-layout">
            <Header />
            <main className="layout-main">
                <Sidebar />
                {children}
            </main>
        </div>
    );
};

export default Layout;
