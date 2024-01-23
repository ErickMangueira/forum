package br.com.erick.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
