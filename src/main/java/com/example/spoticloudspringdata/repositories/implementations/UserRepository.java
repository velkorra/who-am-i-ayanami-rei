package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends AbstractBaseRepository<User, Integer> {
    public UserRepository(JpaRepository<User, Integer> repository) {
        super(repository);
    }

    public void delete(User user) {
        user.setDeleted(true);
    }
    public void deleteById(Integer id) {
        super.findById(id).ifPresent(user -> user.setDeleted(true));
    }

    public User findByUsername(String username){
        return ((UserJpaRepository) repository).findByUsername(username);
    }
    public User findByEmail(String email){
        return ((UserJpaRepository) repository).findByEmail(email);
    }
}

@Repository
interface UserJpaRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);


}