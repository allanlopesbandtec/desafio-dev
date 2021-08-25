package byCoders.desafio.repositories;

import byCoders.desafio.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<Transacao> findTransacaoByLoja_IdLoja(Integer idLoja);
}
