package br.com.erick.forum.service

import br.com.erick.forum.model.Curso
import br.com.erick.forum.model.Topico
import br.com.erick.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService {
    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Duvida kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "anadasilva@email.com"
            )
        )
        return Arrays.asList(topico, topico, topico)
    }
}