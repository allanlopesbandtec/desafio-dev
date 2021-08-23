package byCoders.desafio.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import byCoders.desafio.models.TipoTransacao;
import byCoders.desafio.models.Transacao;
import byCoders.desafio.repositories.TipoTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransacaoService {

    @Autowired
    private TipoTransacaoRepository tipoTransacaoRepository;

    public List<Transacao> leituraCNAB(String nomeArquivo){

        FileReader leitor = null;
        Scanner leitura = null;
        //FileReader representa o arquivo a ser lido
        //Scanner para ler do arquivo

        List<Transacao>  transacaoList = new ArrayList<>();

        List<String> linhas;

        try {
            leitor = new FileReader(nomeArquivo);
            leitura = new Scanner(leitor);
            linhas = Files.readAllLines(new File(nomeArquivo).toPath());


            String registroLinha = "";
            //Será gravado o registro encontrado na linha


            do {
                registroLinha = leitura.nextLine();

                //Dados separados conforme a leitura do documento CNAB

                String tipoString = registroLinha.substring(0, 1);
                String dataString = registroLinha.substring(1, 9);
                String valorString = registroLinha.substring(9, 19);
                String cpfString = registroLinha.substring(19, 30);
                String cartaoString = registroLinha.substring(30, 42);
                String horaString = registroLinha.substring(42, 48);
                String donoString = registroLinha.substring(48, 62);
                String nomeLojaString = registroLinha.substring(62, 80);


                Double valor = Double.parseDouble(valorString) / 100;

                transacaoList.add(
                        new Transacao(null,
                                dataString,
                                valor,
                                Long.parseLong(cpfString),
                                cartaoString,
                                horaString,
                                tipoTransacaoRepository.getById(Integer.parseInt(tipoString)),
                                nomeLojaString.trim(),
                                donoString.trim()));


                }while (leitura.hasNext());

        }catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado");
        } catch (
            NoSuchElementException erro) {
            System.err.println("Arquivo com problema.");
        } catch (IllegalStateException erro) {
            System.err.println("Erro na leitura do arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            leitura.close();
        try {
            leitor.close();
        } catch (IOException erro) {
            System.err.println("Erro ao fechar arquivo.");
        }
    }

        return transacaoList;

    }
}
