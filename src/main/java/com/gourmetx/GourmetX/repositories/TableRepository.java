package com.gourmetx.GourmetX.repositories;

import com.gourmetx.GourmetX.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<TableEntity, Long> {
    
}
