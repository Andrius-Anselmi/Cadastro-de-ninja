package com.java.andrius.cadastrodeninjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;
//precisamos passar a entidade que o JPA vai lidar e o tipo do id
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
