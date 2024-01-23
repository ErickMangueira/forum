package br.com.erick.forum.mapper

import br.com.erick.forum.dto.NovaTopicoForm
import br.com.erick.forum.model.Topico
import br.com.erick.forum.service.CursoService
import br.com.erick.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(private val cursoService: CursoService,
                       private val usuarioService: UsuarioService): Mapper<NovaTopicoForm, Topico> {
    override fun map(t: NovaTopicoForm): Topico {
        return  Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor))
    }

}
