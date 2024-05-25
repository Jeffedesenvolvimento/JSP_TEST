package teste.com.projetos.projetos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teste.com.projetos.projetos.model.MembroAtribuicao;

@Repository
public interface MembroAtribuicaoRepository extends JpaRepository<MembroAtribuicao, Long> {

}
