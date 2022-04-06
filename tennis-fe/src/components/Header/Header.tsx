import "../Header/Header.css";
import { Layout, Row, Col, PageHeader, Button, Menu, Dropdown } from "antd";
import { HomeOutlined, UserOutlined } from "@ant-design/icons";

const { Header } = Layout;

const menuData = (
  <Menu theme="dark" mode="inline">
    <Menu.Item key="1" icon={<HomeOutlined />}>
      Home
    </Menu.Item>
    <Menu.Item key="2" icon={<HomeOutlined />}>
      Home
    </Menu.Item>
    <Menu.Item key="3" icon={<HomeOutlined />}>
      Home
    </Menu.Item>
  </Menu>
);

const HeaderCustom = () => {
  return (
    <Header className="container">
      <PageHeader className="site-page-header" title="App" />
      <Dropdown.Button
        className="dropdown"
        overlay={menuData}
        placement="bottomCenter"
      >
        Name Surname <UserOutlined />
      </Dropdown.Button>
    </Header>
  );
};

export default HeaderCustom;
