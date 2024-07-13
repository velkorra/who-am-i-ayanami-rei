package com.example.spoticloudspringdata.repositories;

import com.example.spoticloudspringdata.entities.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseJpaRepository extends JpaRepository<Release, Integer> {
}
