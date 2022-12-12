package com.pos.backend.BOSS;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PosRepository extends JpaRepository<PosModel,Long> {

    void findByName(String name);
}
