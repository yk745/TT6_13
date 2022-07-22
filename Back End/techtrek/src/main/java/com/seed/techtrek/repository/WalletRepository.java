package com.seed.techtrek.repository;

import com.seed.techtrek.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    List<Wallet> findByUserId(Integer userId);
}
