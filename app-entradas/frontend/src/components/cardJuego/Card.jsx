import { Link } from "react-router-dom";
import './cardStyles.scss'

// eslint-disable-next-line react/prop-types
const Card = ({ id, nombre, descripcion, foto, precio }) => {

  return (
    <div className='card'>
        <h2 className='card_title'>{nombre}</h2>
        <img className='card_img' src={foto} alt={nombre} />
        <p>{descripcion}</p>
        <br />
        <span>Precio: {precio}</span>
        <br />
        <Link to={`/juegos/${id}`}>
          <button className='btn'>vender</button>
        </Link>
    </div>
  )
}

export default Card