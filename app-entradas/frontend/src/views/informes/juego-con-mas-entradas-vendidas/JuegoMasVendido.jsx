import { useState, useEffect } from "react"
import Footer from "../../../components/footer/Footer"
import Navbar from "../../../components/navbar/Navbar"
import './juegoMasVendidoStyles.scss'

const JuegoMasVendido = () => {

    const [juegoMasVendido, setJuegoMasVendido] = useState('')
    const [loaded, setIsLoaded] = useState(false)

    
    useEffect(() => {
        handleGetJuegoMasVendido()
    }, [])
    
    const getJuegoMasVendidoURL = 'http://localhost:8080/informes/juego-con-mas-entradas-vendidas-hasta-hoy'

    const handleGetJuegoMasVendido = async() => {
        try {
            fetch(getJuegoMasVendidoURL, {
                method: "GET",
                headers: { "Content-Type": "application/json" }
              })
              .then( async (response) => {
                  if(response.ok) {
                    const res = await response.json()
                    setJuegoMasVendido(res)
                    setIsLoaded(true)
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
        <main className="juegoMasVendido_container">
            <Navbar type={"empleadoAdministrativo"} />
            <h1>Juego Más Vendido</h1>
            {loaded &&
                <table>
                    <thead>
                        <tr>
                            <th>Posición</th>
                            <th>Nombre Juego</th>
                            <th>Juego Activo</th>
                            <th>Precio Juego</th>
                        </tr>
                    </thead>
                    <tbody>
                        {juegoMasVendido.map( (j, index) => (
                            <tr key={j[0]["Id Juegos"]}>
                                <td>{index + 1}</td>
                                <td>{j[0]["Nombre Juegos"]}</td>
                                <td>{j[0]["Juegos Activos"].toString()}</td>
                                <td>{j[0]["Precio Juegos"]}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            }
            <Footer />
        </main>
    )
}

export default JuegoMasVendido