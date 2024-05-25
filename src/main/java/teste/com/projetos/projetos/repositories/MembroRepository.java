package teste.com.projetos.projetos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teste.com.projetos.projetos.model.Membro;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

}
