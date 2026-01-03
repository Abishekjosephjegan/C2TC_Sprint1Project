package com.mall.service;

import java.util.List;

import com.mall.entity.ShopOwner;

public interface ShopOwnerService {
    ShopOwner addShopOwner(ShopOwner shopOwner);
    ShopOwner updateShopOwner(Long id, ShopOwner shopOwner);
    ShopOwner getShopOwnerById(Long id);
    List<ShopOwner> getAllShopOwners();
    void deleteShopOwner(Long id);
}
