package com.api_vendinha.api.domain.dtos.request

data class ProdutoRequestDto(
    val preco: Float,
    val quantidade: Int,
    val user: Long,
)