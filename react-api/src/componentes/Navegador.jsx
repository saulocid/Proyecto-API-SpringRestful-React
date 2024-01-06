import React from "react";
import { Link } from "react-router-dom";

function Navegador() {
    return(
        <nav>
            <Link to={"/"}>Lista</Link>
            <Link to={"/crear"}>Crear</Link>
        </nav>
    )
}

export default Navegador;