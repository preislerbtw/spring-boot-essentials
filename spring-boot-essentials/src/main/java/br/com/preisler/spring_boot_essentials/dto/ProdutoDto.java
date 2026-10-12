package br.com.preisler.spring_boot_essentials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}