import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import '../components/Login.css';
import '../components/BackgroundColor.css';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  function loginUsuario(e) {
    e.preventDefault();
    console.log(email);
    console.log(password);
  }

  return (
    <Form className="loginbox" onSubmit={loginUsuario}>
      <Form.Group className="mb-3 formboxemail" controlId="email">
        <Form.Label>E-mail: </Form.Label>
        <Form.Control
          type="email"
          placeholder="Insira o seu e-mail"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <Form.Text className="text-muted"></Form.Text>
      </Form.Group>

      <Form.Group className="mb-3 formboxpassword" controlId="password">
        <Form.Label>Senha: </Form.Label>
        <Form.Control
          type="password"
          placeholder="Insira a sua senha"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </Form.Group>
      <Button className="loginbutton" variant="primary" type="submit">
        ENTRAR
      </Button>
    </Form>
  );
}

export default Login;
