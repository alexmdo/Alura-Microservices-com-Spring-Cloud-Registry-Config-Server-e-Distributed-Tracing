package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    private RestTemplate client;

    public CompraService(RestTemplate client) {
        this.client = client;
    }

    public void realizaCompra(CompraDTO compraDTO) {
        ResponseEntity<InfoFornecedorDTO> infoFornecedorDTOResponseEntity = client
                .exchange("http://fornecedor/info/" + compraDTO.getEndereco().getEstado(),
                        HttpMethod.GET, null, InfoFornecedorDTO.class);

        System.out.println(infoFornecedorDTOResponseEntity.getBody().getEndereco());
    }
}
