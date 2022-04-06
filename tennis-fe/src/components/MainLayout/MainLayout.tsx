import "antd/dist/antd.css";
import "../MainLayout/Layout.css";
import MainRoutes from "../../routes/MainRoutes";
import SideMenu from "../SideMenu/SideMenu";
import Header from "../Header/Header";
import Footer from "../Footer/Footer";
import { FunctionComponent } from "react";
import { Content } from "antd/lib/layout/layout";
import { Layout } from "antd";

const MasterLayout: FunctionComponent = ({ children }) => {
  return (
    <Layout className="master-background">
      <Header />
      <div className="content">
        <SideMenu />
        <div className="main">{children}</div>
      </div>
      <Footer />
    </Layout>
  );
};

export default MasterLayout;
