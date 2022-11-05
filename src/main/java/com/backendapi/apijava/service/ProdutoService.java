package com.backendapi.apijava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendapi.apijava.model.Produto;
import com.backendapi.apijava.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar uma lista de produtos
     * @return 
     */
    public List<Produto> obterTodos() {
        return produtoRepository.obterTodos();
    }

    /**
     * Método que retorna o produto encontrado pelo seu id.
     * @param id do produto a ser localizado.
     * @return Retorna o produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(int id) {
        return produtoRepository.obterPorId(id);
    }

    /**
     * Método que adiciona um produto à lista.
     * @param produto
     * @return
     */
    public Produto adicionar(Produto produto) {
        //Regra de negócio para validar o produto.
        return produtoRepository.adicionarProduto(produto);
    }

    /**
     * Método que deleta um produto de acordo
     * com o id passado.
     */
    public void deletar(int id) {
        //Alguma lógica de validação.
        produtoRepository.deletarProduto(id);
    }

    /**
     * Método para atualizar um p´roduto por seu id.
     * @param id do produto a ser atualizado.
     * @param produto produto que será atualizado.
     * @return Retorna o produto atualizado.
     */
    public Produto atualizaProduto(int id, Produto produto) {

        produto.setId(id);

        return produtoRepository.atualizarProduto(produto);
    }
}
