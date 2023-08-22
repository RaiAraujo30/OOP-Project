import logo from './logo.svg';
import './App.css';
import Login from './components/Login';
import './components/BackgroundColor.css'
import './components/Login.css'
import Logo from '../src/imagens/melodylogopequeno.jpg'

function App() {
  return (
    <div className="background">
      <div className="login">
      <img className='logo' src={Logo} alt='MelodyLogo'></img>  
        <Login/>
      </div>
    </div>
  );
}

export default App;
