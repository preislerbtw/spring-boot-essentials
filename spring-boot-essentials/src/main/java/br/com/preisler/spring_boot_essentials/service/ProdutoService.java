
package br.com.preisler.spring_boot_essentials.service;

import br.com.preisler.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.preisler.spring_boot_essentials.dto.ProdutoDto;
import br.com.preisler.spring_boot_essentials.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoEntity.builder()
                .id(1)
                .nome("Notebook")
                .preco(new BigDecimal("5000"))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoEntity.builder()
                .id(2)
                .nome("Iphone")
                .preco(new BigDecimal("7000"))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoEntity.builder()
                .id(3)
                .nome("Mouse")
                .preco(new BigDecimal("500"))
                .quantidade(10)
                .build());
    }

    // listar todos os produtos
    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    // buscar produto pelo ID
    public ProdutoEntity findById(Integer id) throws NotFoundException {
        return PRODUTOS.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundException("Produto não encontrado"));
    }

    // cadastrar produto
    public ProdutoEntity createProduct(ProdutoDto produtoDto) {
        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;

        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .id(identificador)
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .build();

        PRODUTOS.add(novoProduto);

        return novoProduto;
    }

    // att produto
    public ProdutoEntity atualizarProduto(
            ProdutoDto produtoDto, Integer id) throws NotFoundException {

        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundException("Produto não encontrado"));

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;
    }

    // remover produto
    public void removerProduto(Integer id) throws NotFoundException {
        boolean removido = PRODUTOS.removeIf(
                produto -> produto.getId().equals(id));

        if (!removido) {
            throw new NotFoundException("Produto não encontrado");
        }
    }
}