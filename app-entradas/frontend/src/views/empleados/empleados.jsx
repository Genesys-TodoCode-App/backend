import { useEffect, useState } from 'react'
import CardEmpleado from '../../components/cardEmpleado/cardEmpleado.jsx'
import Navbar from '../../components/navbar/Navbar'
import Footer from '../../components/footer/Footer.jsx'
import './empleadosStyles.scss'

const Empleados = () => {

  const [empleados, setEmpleados] = useState([])

  useEffect(() => {
    handleGetEmpleados()
  }, [])
  
  const getEmpleadosURL = 'http://localhost:8080/empleados'

  const handleGetEmpleados = async() => {
      try {
          fetch(getEmpleadosURL, {
            method: "GET",
            headers: { "Content-Type": "application/json" }
          })
          .then( async (response) => {
            if(response.ok) {
              const res = await response.json()
              setEmpleados(res.content);
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
    <main className='empleados_container'>
        <Navbar type={'empleadoAdministrativo'}/>
        <h1>Empleados</h1>
        <section className='empleados'>
          {empleados.map( i => (
            <CardEmpleado key={i["Id Empleado"]} id={i["Id Empleado"]} name={i["Nombre empleado"]} lastname={i["Apellido empleado"]} juego={i["Juegos"]} />
          ))}
        </section>
        <Footer />
    </main>
  )
}

export default Empleados