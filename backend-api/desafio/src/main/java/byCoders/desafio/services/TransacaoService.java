package byCoders.desafio.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import byCoders.desafio.models.OpcaoTransacao;
import byCoders.desafio.models.Transacao;
import byCoders.desafio.models.Loja;
import byCoders.desafio.models.dto.TransacaoDto;
import byCoders.desafio.models.dto.TransacaoLojaDto;
import byCoders.desafio.repositories.LojaRepository;
import byCoders.desafio.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    public List<Transacao> leituraCNAB(String nomeArquivo) {

        FileReader leitor = null;
        Scanner leitura = null;
        //FileReader representa o arquivo a ser lido
        //Scanner para ler do arquivo

        List<Transacao> transacaoList = new ArrayList<>();

        List<String> linhas;

        Loja loja;

        try {
            leitor = new FileReader(nomeArquivo);
            leitura = new Scanner(leitor);
            linhas = Files.readAllLines(new File(nomeArquivo).toPath());


            String registroLinha = "";
            //Será gravado o registro encontrado na linha


            do {
                registroLinha = leitura.nextLine();

                String natureza = "";
                String descricao = "";

                //leitura de cada linha do documento

                int tipo = Integer.parseInt(registroLinha.substring(0, 1));
                String dataString = registroLinha.substring(1, 9);
                String valorString = registroLinha.substring(9, 19);
                String cpfString = registroLinha.substring(19, 30);
                String cartaoString = registroLinha.substring(30, 42);
                String horaString = registroLinha.substring(42, 48);
                String donoString = registroLinha.substring(48, 62);
                String nomeLojaString = registroLinha.substring(62, 80);

                //Dados separados conforme a leitura do documento CNAB

                //Normalização de dados:

                Double valor = Double.parseDouble(valorString) / 100;

                loja = new Loja(null, donoString.trim(), nomeLojaString.trim());


                for (OpcaoTransacao o : OpcaoTransacao.values()) {
                    if (tipo == (o.ordinal() + 1)) {
                        natureza = o.getNatureza();
                        descricao = o.getDescricaoTransacao();
                    }
                }

                transacaoList.add(
                        new Transacao(null,
                                dataString,
                                valor,
                                Long.parseLong(cpfString),
                                cartaoString,
                                horaString,
                                natureza,
                                descricao,
                                loja));

            } while (leitura.hasNext());

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado");
        } catch (
                NoSuchElementException erro) {
            System.err.println("Arquivo com problema.");
        } catch (IllegalStateException erro) {
            System.err.println("Erro na leitura do arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert leitura != null;
            leitura.close();
            try {
                leitor.close();
            } catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
            }
        }

        return transacaoList;

    }

    public List<TransacaoDto> convercaoTransacaoDto(List<Transacao> transacaoList) {

        //Método criado para converter todos os objetos trasacao em
        //trasacao Dto

        List<TransacaoDto> transacoes = new ArrayList<>();

        for (Transacao t : transacaoList) {
            transacoes.add(new TransacaoDto(t, t.getLoja()));
        }

        return transacoes;
    }

    public TransacaoLojaDto convercaoTransacaoLojaDto(List<Transacao> transacaoList) {

        //Método criado para converter todos os objetos trasacao em
        //trasacao Loja Dto para retornar o saldo

        TransacaoLojaDto transacoesLojaDto = new TransacaoLojaDto();

        for (Transacao t : transacaoList) {
            transacoesLojaDto =
                    new TransacaoLojaDto(t.getLoja().getSaldoLoja(),
                            t.getLoja().getNomeLoja(),
                            convercaoTransacaoDto(transacaoList)
            );
        }

        return transacoesLojaDto;
    }

    public ResponseEntity<List<TransacaoDto>> cadastrarLojas(List<Transacao> transacoes) {

        Loja loja;

        for (Transacao t : transacoes) {

            loja = t.getLoja();

            if (lojaRepository.exists(Example.of(loja))) {

                Optional<Loja> lojaBanco = lojaRepository.findOne(Example.of(loja));

                //Adicionando valor no saldo da loja
                if (t.getNatureza().equals("Entrada")) {

                    lojaBanco.get().setSaldoLoja(lojaBanco.get().getSaldoLoja() + t.getValorTransacao());
                    lojaRepository.save(lojaBanco.get());
                    t.setLoja(lojaBanco.get());
                    transacaoRepository.save(t);

                } else {

                    lojaBanco.get().setSaldoLoja(lojaBanco.get().getSaldoLoja() - t.getValorTransacao());
                    lojaRepository.save(lojaBanco.get());
                    t.setLoja(lojaBanco.get());
                    transacaoRepository.save(t);
                }

            } else {

                if (t.getNatureza().equals("Entrada")) {

                    loja.setSaldoLoja(+t.getValorTransacao());
                    lojaRepository.save(loja);
                    t.setLoja(loja);
                    transacaoRepository.save(t);

                } else {

                    loja.setSaldoLoja(-t.getValorTransacao());
                    lojaRepository.save(loja);
                    t.setLoja(loja);
                    transacaoRepository.save(t);
                }
            }
        }

        return ResponseEntity.created(null).body(convercaoTransacaoDto(transacoes));
    }
}
