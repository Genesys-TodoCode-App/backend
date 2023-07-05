/* eslint-disable react/no-unknown-property */
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Navbar from "../../components/navbar/Navbar";
import Footer from "../../components/footer/Footer";
import { IoCloseCircle } from 'react-icons/io5'
import './empleadoStyles.scss'

const Juego = () => {
    const [empleado, setEmpleado] = useState()
    const [juegos, setJuegos] = useState()
    const [juegoAñadir, setJuegoAñadir] = useState()
    const [juegoAñadirID, setJuegoAñadirID] = useState()
    const [touched, setTouched] = useState(false)


    useEffect(() => {
        handleGetEmpleado()
        handleGetJuegos()
        touched && handleGetJuego()
    }, [])
    
    const { id } = useParams();
    const getEmpleadoURL = `http://localhost:8080/empleados/${id}`

    const handleGetEmpleado = async() => {
        try {
            fetch(getEmpleadoURL, {
                method: "GET",
                headers: { "Content-Type": "application/json" }
              })
              .then( async (response) => {
                  if(response.ok) {
                    const res = await response.json()
                    setEmpleado(res)
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
                    setJuegos(res);
                }
            })
              .catch((err) => {
                console.log('Error: ', err)
              })
        } catch (error) {
            console.log('error: ', error)
        }
    }

    const handleChange = (e) => {
        setTouched(true)
        setJuegoAñadirID(e.target.value)
        juegoAñadirID && handleGetJuego()
    }

    const getJuegoURL = `http://localhost:8080/juegos/${juegoAñadirID}`

    const handleGetJuego = async () => {
        try {
            const response = await fetch(getJuegoURL, {
                method: "GET",
                headers: { "Content-Type": "application/json" }
            })
            console.log('response hanldeget juego', response);
            if(response.ok) {
                const res = await response.json()
                setJuegoAñadir(res)
                // console.log('res', res);
                juegoAñadir && console.log('juego a añadir handleGetJuego', juegoAñadir)
            } else {
                console.log('Error en la solicitud fetch handle get juego');
            }
        } catch (error) {
            console.log('Error: ', error)
        }
    }

    const handleAddJuego = async (e) => {
        e.preventDefault()
        // console.log('handleAddJuego empleado: ', empleado);
        // console.log('handleAddJuego juego a añadir: ', juegoAñadir)


        const empleadoActualizado = { ...empleado }
        // console.log('juego añadir', juegoAñadir);
        // empleadoActualizado.Juegos = [...empleado.Juegos, juegoAñadir]
        empleadoActualizado["Juegos asignados"] = [...empleado["Juegos asignados"], juegoAñadir]

        setEmpleado(empleadoActualizado) 

        console.log('nuevo empleado: ', empleadoActualizado)
        
        const putEmpleadoURL = `http://localhost:8080/empleados/${empleado["Id Empleado"]}`

        try {
            // console.log('empleado', empleado)
            const response = await fetch(putEmpleadoURL, {
                method: 'PUT',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(empleadoActualizado)
            })
            // console.log('response put', response)

            if(response.ok) {
                // console.log('empleado put response ', await response.json());
                const res = await response.json()
                console.log('empleado put response ', res);

                setTouched(false)

            } else {
                console.log('Hay un error no se donde')
            } 
        } catch (error) {
            console.log('Error catch: ', error)
        }
    }

    // aca deberia ser una funcion y manejar un estado
    let juegosEmpleado = [];

    for (let x = 0; x < (empleado && empleado["Juegos asignados"].length); x++) {
        juegosEmpleado.push(empleado["Juegos asignados"][x])
    }

    const juegosFiltrados = [];

    for (let i = 0; i < juegos?.length; i++) {
      let juegoEncontrado = false;
      for (let j = 0; j < juegosEmpleado.length; j++) {
        if (juegos[i]["Id Juego"] === juegosEmpleado[j]["Id Juego"]) {
          juegoEncontrado = true;
          break;
        }
      }
      if (!juegoEncontrado) {
        juegosFiltrados.push(juegos[i]);
      }
    }
    // aca deberia ser una funcion y manejar un estado

    return (
        <main className="empleado_container">
            <Navbar type={'empleadoAdministrativo'} />
                {empleado && (
                    <section>
                        <h2>{empleado['Nombre empleado'] + ' ' + empleado['Apellido empleado']}</h2>
                        <h3>Juegos:</h3>
                        {/* {console.log(empleado)} */}
                        <ul>
                            {/* {console.log(empleado)} */}
                            {empleado["Juegos asignados"].map( i => (
                                <li key={i["Id Juego"]}>
                                    {i["Nombre juego"]}
                                    {/* <button className="deleteJuego">X</button> */}
                                    <IoCloseCircle className="deleteJuego" onClick={() =>alert('deleting juego: ' + i["Nombre juego"])} />
                                </li>
                                ))}
                        </ul>
                    </section>
                )}
            <section>
                <form method="put" onSubmit={e => handleAddJuego(e)}>
                    {juegosFiltrados && (
                        <select
                            className=""
                            id="juegos"
                            name="juegos"
                            value={juegoAñadirID}
                            onChange={(e) => handleChange(e)}
                        >
                            {juegosFiltrados.map( j => (
                                <option
                                    key={j["Id Juego"]}
                                    value={j["Id Juego"]}
                                >
                                    {j["Juegos Activos"] ? j["Nombre juego"] : 'Juego inactivo'}
                                </option>
                            ))}
                        </select>
                    )}
                    <br />
                    <button className="btn" type="submit">
                        Añadir juego
                    </button>
                </form>
            </section>
            <Footer />
        </main>
    );
};

export default Juego;
