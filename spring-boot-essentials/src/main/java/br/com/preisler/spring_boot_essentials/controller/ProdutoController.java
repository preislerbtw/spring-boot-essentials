
package br.com.preisler.spring_boot_essentials.controller;

import br.com.preisler.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.preisler.spring_boot_essentials.dto.ProdutoDto;
import br.com.preisler.spring_boot_essentials.exception.NotFoundException;
import br.com.preisler.spring_boot_essentials.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity findById(@PathVariable Integer id)
            throws NotFoundException {
        return produtoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity createProduct(
            @RequestBody ProdutoDto produtoDto) {
        return produtoService.createProduct(produtoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity atualizarProduto(
            @RequestBody ProdutoDto produtoDto,
            @PathVariable Integer id) throws NotFoundException {
        return produtoService.atualizarProduto(produtoDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProduto(@PathVariable Integer id) throws NotFoundException {
        produtoService.removerProduto(id);
    }
}