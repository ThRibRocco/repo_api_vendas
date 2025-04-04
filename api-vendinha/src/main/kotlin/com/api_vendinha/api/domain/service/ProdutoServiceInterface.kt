package com.api_vendinha.api.domain.service
import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto

interface ProdutoServiceInterface {
    fun save(produtoRequestDto: ProdutoRequestDto): ProdutoResponseDto
    fun update(id:Long, produtoRequestDto: ProdutoRequestDto): ProdutoResponseDto
    fun findProduto(id: Long) : ProdutoResponseDto

}