package br.com.preisler.spring_boot_essentials.database.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntity {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}