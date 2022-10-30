package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    private FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    public void realizaCompra(CompraDTO compraDTO) {
        InfoFornecedorDTO infoPorEstado = fornecedorClient.getInfoPorEstado(compraDTO.getEndereco().getEstado());
        System.out.println(infoPorEstado.getEndereco());
    }
}
