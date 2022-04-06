import { FunctionComponent, useState } from "react";
import "antd/dist/antd.css";
import "../LoginForm/Login.css";
import { Button, Form, Input } from "antd";

const Login: FunctionComponent = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  return (
    <Form name="LoginForm">
      <h1 className="form-title">Prijava</h1>
      <Form.Item
        className="input-row"
        label="Username"
        name="username"
        rules={[
          {
            required: true,
            message: "username required",
          },
        ]}
      >
        <Input
          className="input-login-textbox"
          value={username}
          maxLength={50}
          //onChange={(e) => setUsername(e.target.value)}
        />
      </Form.Item>
      <Form.Item
        className="input-row"
        label="Password"
        name="password"
        rules={[
          {
            required: true,
            message: "password required",
          },
        ]}
      >
        <Input
          className="input-login-textbox"
          value={username}
          maxLength={50}
          //onChange={(e) => setUsername(e.target.value)}
        />
      </Form.Item>

      <Form.Item>
        <Button
          type="primary"
          htmlType="submit"
          //onClick={() => userLogin()}
          className="prijava-button"
        >
          Login
        </Button>
      </Form.Item>
    </Form>
  );
};
export default Login;