package com.parika.inspection.manager.repositories;
import com.parika.inspection.manager.models.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProfilesRepo extends JpaRepository<Profiles, Integer> {
}
