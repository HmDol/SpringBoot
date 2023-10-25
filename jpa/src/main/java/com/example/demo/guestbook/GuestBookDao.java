package com.example.demo.guestbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestBookDao extends JpaRepository<GuestBook2, Integer> {

}
