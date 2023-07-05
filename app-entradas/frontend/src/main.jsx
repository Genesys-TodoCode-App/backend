import React from 'react'
import ReactDOM from 'react-dom/client'
import Login from './Login.jsx'
import Juegos from './views/juegos/Juegos.jsx'
import Juego from './views/juego/Juego.jsx'
import AgregarComprador from './views/agregarComprador/agregarComprador.jsx'
import Empleados from './views/empleados/empleados.jsx'
import Empleado from './views/empleado/empleado.jsx'
import Ventas from './views/ventas/Ventas.jsx'
import VentasMesAño from './views/informes/ventas-mes-año/VentasMesAño.jsx'
import VentasEnFecha from './views/informes/ventas-en-fecha/VentasEnFecha.jsx'
import JuegoMasVendido from './views/informes/juego-con-mas-entradas-vendidas/JuegoMasVendido.jsx'
import EntradasPorJuegoYFecha from './views/informes/entradas-por-juego-y-fecha/EntradasPorJuegoYFecha.jsx'
import EntradasVendidasEnFecha from './views/informes/entradas-vendidas-en-fecha/EntradasVendidasEnFecha.jsx'
import EmpleadosConJuegosAsignados from './views/informes/empleados-con-juegos-asignados/EmpleadosConJuegosAsignados.jsx'
import CompradorConMasEntradasPagadas from './views/informes/comprador-con-mas-entradas-pagadas/CompradorConMasEntradasPagadas.jsx'
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import './index.css'

const router = createBrowserRouter([
  {
    path: "/",
    element: <Login />,
  },
  {
    path: "/juegos",
    element: <Juegos />,
  },
  {
    path: "/juegos/:id",
    element: <Juego />,
  },
  {
    path: "/add-buyer",
    element: <AgregarComprador />,
  },
  {
    path: "/empleados",
    element: <Empleados />,
  },
  {
    path: "/empleados/:id",
    element: <Empleado />,
  },
  {
    path: "/ventas",
    element: <Ventas />,
  },
  {
    path: "/ventas-mes-año",
    element: <VentasMesAño />,
  },
  {
    path: "/ventas-fecha",
    element: <VentasEnFecha />,
  },
  {
    path: "/juego-con-mas-entradas-vendidas",
    element: <JuegoMasVendido />,
  },
  {
    path: "/entradas-por-juego-y-fecha",
    element: <EntradasPorJuegoYFecha />,
  },
  {
    path: "/entradas-vendidas-en-fecha",
    element: <EntradasVendidasEnFecha />,
  },
  {
    path: "/empleados-con-juegos-asignados",
    element: <EmpleadosConJuegosAsignados />,
  },
  {
    path: "/comprador-con-mas-entradas-pagadas",
    element: <CompradorConMasEntradasPagadas />,
  }
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
