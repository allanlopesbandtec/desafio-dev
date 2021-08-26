package byCoders.desafio.controllers;

import byCoders.desafio.models.Loja;
import byCoders.desafio.models.dto.TransacaoDto;
import byCoders.desafio.repositories.LojaRepository;
import byCoders.desafio.repositories.TransacaoRepository;
import byCoders.desafio.services.TransacaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LojaController.class)
class LojaControllerTest {

    @Autowired
    LojaController controller;

    @MockBean
    LojaRepository repositoryMock;

    @MockBean
    TransacaoService serviceMock;

    @Test
    @DisplayName("todasAsLojas1() deve trazer as lojas e retornar status 200")
    void todasAsLojas1(){

        List<Loja> lojas
                = Arrays.asList(Mockito.mock(Loja.class));

        Mockito.when(
                repositoryMock.findAll())
                .thenReturn(lojas);

        ResponseEntity resposta = controller.todasLojas();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(lojas, resposta.getBody());

    }

    @Test
    @DisplayName("todasAsLojas2() não deve trazer as lojas e retornar status 204")
    void todasAsLojas2(){


        Mockito.when(
                repositoryMock.findAll())
                .thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.todasLojas();

        assertEquals(204, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());

    }



}