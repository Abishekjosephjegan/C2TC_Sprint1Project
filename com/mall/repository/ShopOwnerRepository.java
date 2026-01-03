package com.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.entity.ShopOwner;

@Repository
public interface ShopOwnerRepository extends JpaRepository<ShopOwner, Long> {
}
