export async function listarPersonas() {
    try {
        const res = await fetch('http://localhost:8080/personas')
        const data = await res.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

export async function savePersona(persona) {
    try {
      const response = await fetch('http://localhost:8080/personas/guardar', persona, {
        headers: {
          'Content-Type': 'application/json',
        //   Authorization: 'Basic ' + btoa('admin:admin'),
        },
      });
  
      // Puedes manejar la respuesta si es necesario
      console.log('Respuesta del servidor:', response.data)
    } catch (error) {
      console.error('Error al enviar la solicitud:', error)
    }
  }

export async function deletePersona(id) {
    try {
        await fetch(`http://localhost:8080/personas/borrar/${id}`,{
            method: "DELETE"
        })
    } catch (error) {
        console.log(error)
    }
}