package byCoders.desafio.controllers;


import byCoders.desafio.models.Transacao;
import byCoders.desafio.models.dto.TransacaoDto;
import byCoders.desafio.models.dto.TransacaoLojaDto;
import byCoders.desafio.repositories.TransacaoRepository;
import byCoders.desafio.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @Autowired
    TransacaoRepository transacaoRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> importarTransacao(@RequestParam("arquivo") MultipartFile arquivoRecebido) throws IOException {


        List<Transacao> listaTransacoes = new ArrayList<>();

        //Validação caso o arquivo esteja vázio ou endpoint acionado sem enviar um arquivo.

        if (arquivoRecebido.isEmpty()){
            return ResponseEntity.badRequest().body("Arquivo não enviado / vazio!");
        }

        else{
            //Cenário com arquivo recebido

            System.out.println("Recebendo um arquivo do tipo: " + arquivoRecebido.getContentType());

            byte[]  conteudo = arquivoRecebido.getBytes();

            //Vetor de bytes criado para reber o arquivo

            Path path = Paths.get(arquivoRecebido.getOriginalFilename());
            //Classe path para identificar o caminho e nome do arquivo

            System.out.println("Nome do arquivo: " + path.getFileName());

            Files.write(path, conteudo);

            //Acionando método da TransacaoService para ler o arquivo e retornar um List de transacoes.
            return transacaoService.cadastrarLojas( transacaoService.leituraCNAB(arquivoRecebido.getOriginalFilename()));
        }

    }

    @GetMapping
    public ResponseEntity<List<TransacaoDto>> listagemTransacoes(){

        List<TransacaoDto> transacaoDtos = transacaoService.convercaoTransacaoDto(transacaoRepository.findAll());

        if (transacaoDtos.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(transacaoDtos);
        }
    }

    @GetMapping("/{idLoja}")
    public ResponseEntity<TransacaoLojaDto> listagemPorLoja(@PathVariable Integer idLoja){

        TransacaoLojaDto transacaoDto = transacaoService.convercaoTransacaoLojaDto(
                transacaoRepository.findTransacaoByLoja_IdLoja(idLoja));

        if (transacaoDto.getLojasList().isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(transacaoDto);
        }

    }


}
