// import juegos from "./mockJuegos.js";
import { useEffect, useState } from 'react'
import Card from "../../components/cardJuego/Card.jsx";
import "./juegosStyles.scss";
import Navbar from '../../components/navbar/Navbar.jsx';
import Footer from '../../components/footer/Footer.jsx';

const Juegos = () => {
    const [juegos, setJuegos] = useState([])

    useEffect(() => {
        handleGetJuegos()
    }, [])
    
    const getJuegosURL = 'http://localhost:8080/juegos'

    const handleGetJuegos = async() => {
        try {
            fetch(getJuegosURL, {
                method: "GET",
                headers: { "Content-Type": "application/json" }
              })
            .then( async (response) => {
                if(response.ok) {
                    const res = await response.json()
                    setJuegos(res)
                } else {
                    console.log('Hay un error')
                }
            })
            .catch((err) => {
                console.log('Error: ', err)
            })
        } catch (error) {
            console.log('error: ', error)
        }
    }

    return (
        <main className="juegos_container">
            <Navbar type={'empleadoJuego'} />
            <h1>Juegos</h1>
            <section className="cards_juegos">
                {juegos && juegos.map((juego) => (
                    <Card
                        key={juego["Id Juego"]}
                        id={juego["Id Juego"]}
                        nombre={juego["Nombre juego"]}
                        descripcion={juego["Descripciones"]}
                        foto={juego["Rutas a las fotos"]}
                        precio={juego["Precio juego"]}
                    />
                ))}
            </section>
            <Footer  />
        </main>
    );
};

export default Juegos;
