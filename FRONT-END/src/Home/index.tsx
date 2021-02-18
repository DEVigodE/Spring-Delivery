import { ReactComponent as MainImage } from './main.svg';
import './styles.css'

function Home() {
  return (
    <div className="home-container">
      <div className="home-content">
        <div className="home-actions">
          <h1>
            Faça seu pedido <br /> que entregamos<br /> pra você!!!
          </h1>
          <h3>
            Escolha o seu pedido e em poucos minutos<br /> levaremoss na sua porta
          </h3>
          <a href="order" className="home-btn-order">
            FAZER PEDIDO
          </a>
        </div>
        <div className="home-image">
          <MainImage />
        </div>
      </div>
    </div>
  )
}

export default Home;