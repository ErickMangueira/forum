package br.com.erick.forum.service

import br.com.erick.forum.dto.AtualizacaoTopicoForm
import br.com.erick.forum.dto.NovaTopicoForm
import br.com.erick.forum.dto.TopicoPorCategoriaDto
import br.com.erick.forum.dto.TopicoView
import br.com.erick.forum.exceptions.NotFoundException
import br.com.erick.forum.mapper.TopicoFormMapper
import br.com.erick.forum.mapper.TopicoViewMapper
import br.com.erick.forum.model.Topico
import br.com.erick.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String?
) {
    fun listar(nomeCurso: String?, paginacao: Pageable): Page<TopicoView> {
        val topicos = if (nomeCurso == null ){
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map {t -> topicoViewMapper.map(t)}
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovaTopicoForm): TopicoView {
        var topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
      repository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoriaDto> {
        return repository.relatorio()
    }
}