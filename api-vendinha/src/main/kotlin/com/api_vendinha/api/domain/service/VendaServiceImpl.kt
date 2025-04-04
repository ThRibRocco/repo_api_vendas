package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.VendaRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
import com.api_vendinha.api.domain.dtos.response.VendaResponseDto
import com.api_vendinha.api.domain.entities.Venda
import com.api_vendinha.api.infrastructure.repository.ProdutoRepository
import com.api_vendinha.api.infrastructure.repository.UserRepository
import com.api_vendinha.api.infrastructure.repository.VendaRepository;
import org.springframework.stereotype.Service;

@Service
class VendaServiceImpl (
    private val vendaRepository:VendaRepository,
    private val produtoRepository: ProdutoRepository,
    private val userRepository: UserRepository
): VendaServiceInterface {
    override fun save(vendaRequestDto: VendaRequestDto): VendaResponseDto {

        var user = userRepository.findById(vendaRequestDto.user).orElseThrow();

        var produto = produtoRepository.findById(vendaRequestDto.produto).orElseThrow();

        val  venda = vendaRepository.save(
            Venda(
                total_compra = vendaRequestDto.total_compra,
                user = user,
                produto = produto,
                quantidade = vendaRequestDto.quantidade,
            )
        );

        var produtos = produto.quantidade - venda.quantidade;

        produto.quantidade = produtos


        //pergunta: A parte lógica de colocar um colocar um limite para vender um determidado produto precisa ser colocado ou não neste caso?


        //faz um findById e pega os dados do produto para realizar o total da venda
        //pegar o produto sub a quantidade do produto que vc vendeu
        //update o produto com a nova quantidade

        return  VendaResponseDto(
            id = venda.id,
            total_compra = venda.total_compra,
            user = UserResponseDto(
                id = user.id,
                name = user.name,
                email = user.email,
                password = user.password,
                cpf_cnpj = user.cpf_cnpj,
                is_active = user.is_active
            ),
            produto = ProdutoResponseDto(
                id = produto.id,
                preco = produto.preco,
                quantidade = produto.quantidade,
                user = UserResponseDto(
                    id = user.id,
                    name = user.name,
                    email = user.email,
                    password = user.password,
                    cpf_cnpj = user.cpf_cnpj,
                    is_active = user.is_active
                )
            ),
            quantidade = venda.quantidade
        )
    }
}