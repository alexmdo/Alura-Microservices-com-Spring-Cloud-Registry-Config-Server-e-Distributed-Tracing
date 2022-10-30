package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.controller.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    private FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    public Compra realizaCompra(CompraDTO compraDTO) {
        InfoFornecedorDTO infoPorEstado = fornecedorClient.getInfoPorEstado(compraDTO.getEndereco().getEstado());
        InfoPedidoDTO infoPedidoDTO = fornecedorClient.realizaPedido(compraDTO.getItens());

        Compra compra = new Compra();
        compra.setPedidoId(infoPedidoDTO.getId());
        compra.setTempoDePreparo(infoPedidoDTO.getTempoDePreparo());
        compra.setEnderecoDestino(compraDTO.getEndereco().toString());

        System.out.println(infoPorEstado.getEndereco());

        return compra;
    }
}
