package com.example.spoticloudspringdata.repositories.base.classes;

import com.example.spoticloudspringdata.entities.SoftDeletable;
import com.example.spoticloudspringdata.repositories.base.interfaces.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseRepository<T extends SoftDeletable, Id> implements BaseRepository<T, Id> {
    protected final JpaRepository<T, Id> repository;

    public AbstractBaseRepository(JpaRepository<T, Id> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);

    }

    @Override
    public Optional<T> findById(Id id) {
        return repository.findById(id).filter(e -> !e.isDeleted());
    }

    @Override
    public List<T> findAll() {
        return repository.findAll().stream().filter(e -> !e.isDeleted()).toList();
    }
}
