package com.backendapi.apijava.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.backendapi.apijava.model.Produto;

@Repository
public class ProdutoRepository {
    
    //Simulando o banco de dados.
    private List<Produto> produtos = new ArrayList<Produto>();
    private int ultimoId = 0;

    /**
     * Retorna uma lista de produtos
     * @return lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param  do produto que será localizado
     * @return Retorna um produto caso encontrado.
     */
    public Optional<Produto> obterPorId(int id){ //Optional, ajuda a evitar um erro, se não houver um produto com esse id, ele retorna null.
        return produtos.stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
    }

    /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return Retorna o produto que foi adicionado.
     */
    public Produto adicionarProduto(Produto produto) {

        ultimoId ++;
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Método que deleta o produto por Id.
     * @param id do produto a ser deletado.
     */
    public void deletarProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return Retorna o produto atualizado.
     */
    public Produto atualizarProduto(Produto produto) {

        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        deletarProduto(produto.getId());

        produtos.add(produto);
        return produto;
    }
}
