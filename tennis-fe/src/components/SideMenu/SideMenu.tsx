import { FunctionComponent, useState } from "react";
import "./SideMenu.css";
import { Menu } from "antd";
import { Layout } from "antd";
import { HomeOutlined } from "@ant-design/icons";
import { Link } from "react-router-dom";

const SideMenu: FunctionComponent = () => {
  const { Sider } = Layout;
  const [collapsed, setCollapsed] = useState(false);

  const toggleCollapsed = () => {
    collapsed ? setCollapsed(false) : setCollapsed(true);
  };
  return (
    <Sider
      className="sideMenu-main"
      collapsible
      collapsed={collapsed}
      onCollapse={toggleCollapsed}
    >
      <Menu theme="dark" mode="inline">
        <Menu.Item key="1" icon={<HomeOutlined />}>
          <Link to={"/"}>Login</Link>
        </Menu.Item>
        <Menu.Item key="2" icon={<HomeOutlined />}>
          <Link to={"/register"}>Register</Link>
        </Menu.Item>
        <Menu.Item key="3" icon={<HomeOutlined />}>
          <Link to={"/match"}>Match</Link>
        </Menu.Item>
        <Menu.Item key="4" icon={<HomeOutlined />}>
          <Link to={"/location"}>Location</Link>
        </Menu.Item>
        <Menu.Item key="5" icon={<HomeOutlined />}>
          Home
        </Menu.Item>
      </Menu>
    </Sider>
  );
};

export default SideMenu;
