package com.backendapi.apijava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendapi.apijava.model.Produto;
import com.backendapi.apijava.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> obterTodos() {
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable int id) {

        return produtoService.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {

        return produtoService.adicionar(produto);
    }

    
    @PutMapping("/{id}")
    public Produto atualizar (@RequestBody int id, @RequestBody Produto produto) {
        
        return produtoService.atualizaProduto(id, produto);
    }
    
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id) {

        produtoService.deletar(id);

        return "Produto com o id: " + id + " foi deletado com sucesso!";
    }
}
