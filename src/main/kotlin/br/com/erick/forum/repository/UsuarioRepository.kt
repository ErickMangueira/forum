package br.com.erick.forum.repository

import br.com.erick.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
}