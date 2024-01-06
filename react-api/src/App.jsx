import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Navegador from './componentes/Navegador'
import ListaPersonas from './componentes/ListaPersonas'
import FormularioPersona from './componentes/FormularioPersona'

function App() {

  return (
    <>
      <h4>Aplicación de consumo de API Spring en React</h4>
      <BrowserRouter>
      <Navegador/>
        <Routes>
          <Route path='/' element={<ListaPersonas/>}/>
          <Route path='/crear' element={<FormularioPersona/>}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
