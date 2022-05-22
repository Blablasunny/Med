package com.med.repository;

import com.med.domain.Write;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriteRepository extends JpaRepository<Write, Integer> {
}
