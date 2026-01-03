package com.mall.service.impl;

import com.mall.entity.ShopOwner;
import com.mall.repository.ShopOwnerRepository;
import com.mall.service.ShopOwnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopOwnerServiceImpl implements ShopOwnerService {

    private final ShopOwnerRepository repository;

    public ShopOwnerServiceImpl(ShopOwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShopOwner addShopOwner(ShopOwner shopOwner) {
        return repository.save(shopOwner);
    }

    @Override
    public ShopOwner updateShopOwner(Long id, ShopOwner shopOwner) {
        ShopOwner existing = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Shop Owner not found"));

        existing.setName(shopOwner.getName());
        existing.setDob(shopOwner.getDob());
        existing.setAddress(shopOwner.getAddress());
        existing.setShopId(shopOwner.getShopId());

        return repository.save(existing);
    }

    @Override
    public ShopOwner getShopOwnerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop Owner not found"));
    }

    @Override
    public List<ShopOwner> getAllShopOwners() {
        return repository.findAll();
    }

    @Override
    public void deleteShopOwner(Long id) {
        repository.deleteById(id);
    }
}
