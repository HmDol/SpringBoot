package com.example.demo.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookDao extends JpaRepository<Book2, Integer> {

}
