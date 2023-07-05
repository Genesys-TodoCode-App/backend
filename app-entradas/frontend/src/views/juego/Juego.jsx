import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Navbar from "../../components/navbar/Navbar";
import Footer from "../../components/footer/Footer";
import "./juegoStyles.scss";

const Juego = () => {
    const [comprador, setComprador] = useState()
    const [compradores, setCompradores] = useState([
        {
        "idComprador": 1,
        "nombreComprador": "Juan",
        "apellidoComprador": "Pérez",
        "dniComprador": "12345678",
        "correoElectronicoComprador": "juan.perez@example.com",
        "paseDeOro": true
        },
        {
        "idComprador": 2,
        "nombreComprador": "María",
        "apellidoComprador": "González",
        "dniComprador": "87654321",
        "correoElectronicoComprador": "maria.gonzalez@example.com",
        "paseDeOro": false
        },
        {
        "idComprador": 3,
        "nombreComprador": "Pedro",
        "apellidoComprador": "Rodríguez",
        "dniComprador": "98765432",
        "correoElectronicoComprador": "pedro.rodriguez@example.com",
        "paseDeOro": true
        },
    ])

    const [juego, setJuego] = useState({
        "idJuego": 1,
        "nombreJuego": "Montaña Rusa",
        "precioJuego": 10,
        "cobroPaseOro": true,
        "horarios": [
            {
                "idHorarioJuego": 1,
                "horaInicio": "2023-06-19T16:00:00",
                "horaFin": "2023-06-19T20:00:00"
            },
            {
                "idHorarioJuego": 2,
                "horaInicio": "2023-06-20T16:00:00",
                "horaFin": "2023-06-20T20:00:00"
            },
            {
                "idHorarioJuego": 3,
                "horaInicio": "2023-06-21T16:00:00",
                "horaFin": "2023-06-21T20:00:00"
            }
        ]
    })

    useEffect(() => {
        handleGetCompradores()
        handleGetJuego()
    }, [compradores, juego])

    const handleSell = (e) => {
        e.preventDefault()
        handleSubmit()
    };

    const handleSubmit = async () => {

        const postEntradaURL = `http://localhost:8080/entradas`

        const now = new Date();
        const currentDateTime = now.toLocaleString();

        const entrada = {
            "Id Entrada": 0,
            "Codigo Identificacion Entrada": "",
            "Fecha y Hora Utilizacion": currentDateTime,
            "Id juego": juego["Id Juegos"],
            "Nombre del Juego": juego["Nombre Juegos"]
        }

        // console.log('juego entrada', juego);
        console.log('entrada', entrada);


        try {
            const response = await fetch(postEntradaURL, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(entrada)
            })
            if(response.ok) {
                if (response.headers.get("Content-Length") > 0) {
                    const res = await response.json();
                    alert(`Entrada vendida a ${comprador}`)
                    setComprador(res);
                } else {
                    alert(`Entrada vendida a ${comprador}`)
                    setComprador(response);
                }
            } else {
                console.log('response', response);
            }
        } catch (error) {
            console.log('Hubo un error: ', error)
        }
    }

    const getCompradoresURL = 'http://localhost:8080/compradores'

    const handleGetCompradores = async() => {
        try {
            fetch(getCompradoresURL, {
                method: "GET",
                headers: { "Content-Type": "application/json" }
              })
              .then( async (response) => {
                  if(response.ok) {
                    const res = await response.json()
                    setCompradores(res)
                  } else {
                    console.log('Hay un error no se donde')
                  }
                })
              .catch((err) => {
                console.log('Error: ', err)
              })
        } catch (error) {
            console.log('Hubo un error: ', error)
        }
    }
    
    const { id } = useParams();
    const getJuegosURL = `http://localhost:8080/juegos/${id}`

    const handleGetJuego = async() => {
        try {
            fetch(getJuegosURL, {
                method: "GET",
                headers: { "Content-Type": "application/json" }
              })
              .then( async (response) => {
                  if(response.ok) {
                    const res = await response.json()
                    setJuego(res)
                  } else {
                    console.log('Hay un error no se donde')
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
        <main className="juego_container">
            <Navbar type={'empleadoJuego'} />
            <section className="juego">
                {/* {console.log('juego: ', juego)} */}
                <h1 className="juego_title">{juego["Nombre Juegos"]}</h1>
                <img
                    className="juego_img"
                    src={juego["Rutas a las fotos"]}
                    alt={juego["Nombre Juegos"]}
                />
                <p>Horarios:
                    <br />
                    {juego.horarios.map( i => (
                        <span key={i["Id Horario Juego"]}>
                            {i["Hora Inicio"] + " "} - {i["Hora Fin"] + " "}
                            <br />
                        </span>
                    ))}
                </p>
                <span>Precio: ${juego["Precio Juegos"]}</span>
            </section>
            <section className="comprador">
                <form>
                    <select
                        className="select_buyer"
                        id="comprador"
                        name="comprador"
                        value={comprador ? comprador["Id Comprador"] : ""}
                        onChange={(c) => setComprador(
                            compradores.content?.find(
                                (comprador) => comprador["Id Comprador"] === Number(c.target.value)
                            )
                        )}
                    >
                        {compradores.content?.map((c) => (
                            <option key={c["Id Comprador"]} value={c["Id Comprador"]}>
                                {c["Nombre Comprador"] + " " + c["Apellido Comprador"]}
                            </option>
                        ))}
                    </select>
                    <br />
                    <button className="btn" onClick={e => handleSell(e)} type="submit">
                        Vender
                    </button>
                </form>
            </section>
            <Footer />
        </main>
    );
};

export default Juego;
