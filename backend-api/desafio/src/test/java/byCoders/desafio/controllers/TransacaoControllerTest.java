package byCoders.desafio.controllers;


import byCoders.desafio.models.Transacao;
import byCoders.desafio.models.dto.TransacaoDto;
import byCoders.desafio.models.dto.TransacaoLojaDto;
import byCoders.desafio.repositories.TransacaoRepository;
import byCoders.desafio.services.TransacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TransacaoController.class)
class TransacaoControllerTest {

    @Autowired
    TransacaoController controller;

    @MockBean
    TransacaoRepository repositoryMock;

    @MockBean
    TransacaoService serviceMock;

    @Test
    @DisplayName("listagem deve trazer as transações e retornar status 200")
    void listagemTransacoesCenario1() {

        List<TransacaoDto> transacoesDto
                = Arrays.asList(Mockito.mock(TransacaoDto.class));

        Mockito.when(
                serviceMock.convercaoTransacaoDto(repositoryMock.findAll()))
                        .thenReturn(transacoesDto);


        ResponseEntity resposta = controller.listagemTransacoes();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(transacoesDto, resposta.getBody());
    }

    @Test
    @DisplayName("listagem não deve trazer as transações e retornar status 204")
    void listagemTransacoesCenario2() {

        Mockito.when(
                serviceMock.convercaoTransacaoDto(repositoryMock.findAll()))
                .thenReturn(new ArrayList<>());


        ResponseEntity resposta = controller.listagemTransacoes();

        assertEquals(204, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }

    //@Test
    @DisplayName("listagem deve trazer transações por loja e retornar status 200")
    void listagemPorLojaCenario1() {

        int idLoja = 1;

        TransacaoLojaDto transacaoLojaDto = Mockito.mock(TransacaoLojaDto.class);

        Mockito.when(
                serviceMock.convercaoTransacaoLojaDto(repositoryMock.findTransacaoByLoja_IdLoja(idLoja)))
                .thenReturn(transacaoLojaDto);

        ResponseEntity resposta = controller.listagemPorLoja(idLoja);

        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(transacaoLojaDto, resposta.getBody());
    }

    @Test
    @DisplayName("listagem não deve trazer transações por loja e retornar status 404")
    void listagemPorLojaCenario2() {

        int idLoja = 1;

        Mockito.when(
                serviceMock.convercaoTransacaoLojaDto(
                        repositoryMock.findTransacaoByLoja_IdLoja(idLoja)))
                .thenReturn(new TransacaoLojaDto());

        ResponseEntity resposta = controller.listagemPorLoja(idLoja);

        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }
}