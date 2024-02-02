package br.com.erick.forum.service

import br.com.erick.forum.model.Usuario
import br.com.erick.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.Arrays
@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return  repository.getReferenceById(id)
    }

}
