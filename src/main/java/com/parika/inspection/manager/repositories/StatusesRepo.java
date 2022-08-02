package com.parika.inspection.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parika.inspection.manager.models.Status;

public interface StatusesRepo extends JpaRepository<Status, Integer> {
}
