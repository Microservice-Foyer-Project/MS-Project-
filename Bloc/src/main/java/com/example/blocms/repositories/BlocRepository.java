package com.example.blocms.repositories;

import com.example.blocms.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
