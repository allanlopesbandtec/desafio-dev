package byCoders.desafio.repositories;

import byCoders.desafio.models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Integer> {
}
