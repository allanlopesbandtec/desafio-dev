package byCoders.desafio.controllers;

import byCoders.desafio.models.Loja;
import byCoders.desafio.repositories.LojaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lojas")
public class LojaController {


    @Autowired
    private LojaRepository lojaRepository;


    @GetMapping
    public ResponseEntity<List<Loja>> todasLojas(){

        List<Loja> lojas = lojaRepository.findAll();

        if (lojas.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(lojas);
        }
    }
}
