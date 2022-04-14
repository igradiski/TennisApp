import { Button, Form, Input } from "antd";
import { FunctionComponent, useState } from "react";
import "../RegisterForm/Register.css";
const Register: FunctionComponent = () => {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [mail, setMail] = useState("");

  return (
    <Form name="RegisterForm">
      <h1 className="form-title">Register</h1>
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
          style={{
            background: "#ffd8bf",
            border: "solid #d4380d",
            textAlign: "center",
            fontWeight: "bold",
          }}
          className="input-login-textbox"
          value={username}
          maxLength={50}
          onChange={(e) => setUsername(e.target.value)}
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
          style={{
            background: "#ffd8bf",
            border: "solid #d4380d",
            textAlign: "center",
            fontWeight: "bold",
          }}
          className="input-login-textbox"
          value={password}
          maxLength={50}
          onChange={(e) => setPassword(e.target.value)}
        />
      </Form.Item>
      <Form.Item
        className="input-row"
        label="Name"
        name="name"
        rules={[
          {
            required: true,
            message: "name required",
          },
        ]}
      >
        <Input
          style={{
            background: "#ffd8bf",
            border: "solid #d4380d",
            textAlign: "center",
            fontWeight: "bold",
          }}
          className="input-login-textbox"
          value={name}
          maxLength={50}
          onChange={(e) => setName(e.target.value)}
        />
      </Form.Item>
      <Form.Item
        className="input-row"
        label="Surname"
        name="surname"
        rules={[
          {
            required: true,
            message: "surname required",
          },
        ]}
      >
        <Input
          style={{
            background: "#ffd8bf",
            border: "solid #d4380d",
            textAlign: "center",
            fontWeight: "bold",
          }}
          className="input-login-textbox"
          value={surname}
          maxLength={50}
          onChange={(e) => setSurname(e.target.value)}
        />
      </Form.Item>
      <Form.Item
        className="input-row"
        label="Email"
        name="email"
        rules={[
          {
            required: true,
            message: "surname required",
          },
        ]}
      >
        <Input
          style={{
            background: "#ffd8bf",
            border: "solid #d4380d",
            textAlign: "center",
            fontWeight: "bold",
          }}
          className="input-login-textbox"
          value={mail}
          maxLength={50}
          onChange={(e) => setMail(e.target.value)}
        />
      </Form.Item>

      <Form.Item>
        <Button
          type="primary"
          htmlType="submit"
          //onClick={() => userLogin()}
          className="prijava-button"
        >
          Register
        </Button>
      </Form.Item>
    </Form>
  );
};

export default Register;
