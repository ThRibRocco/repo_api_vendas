package com.api_vendinha.api.domain.dtos.response

data class ProdutoResponseDto(

    val id: Long?,
    val preco: Float,
    val quantidade: Int,
    val user: UserResponseDto,
)