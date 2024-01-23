package br.com.erick.forum.service

import br.com.erick.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.Arrays
@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
         val usuario = Usuario (
            id = 1,
            nome = "Erick",
            email = "erick@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }
    fun buscarPorId(id: Long): Usuario {
        return  usuarios.stream().filter { a -> a.id == id }
                .findFirst().get()
    }

}
