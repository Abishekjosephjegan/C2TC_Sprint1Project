package com.mall.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.dto.ShopOwnerRequest;
import com.mall.entity.ShopOwner;
import com.mall.service.ShopOwnerService;

@RestController
@RequestMapping("/api/shop-owner")
public class ShopOwnerController {

    private final ShopOwnerService service;

    public ShopOwnerController(ShopOwnerService service) {
        this.service = service;
    }

    @PostMapping
    public ShopOwner create(@RequestBody ShopOwnerRequest request) {
        ShopOwner owner = new ShopOwner();
        owner.setName(request.getName());
        owner.setDob(request.getDob());
        owner.setAddress(request.getAddress());
        owner.setShopId(request.getShopId());
        return service.addShopOwner(owner);
    }

    @GetMapping("/{id}")
    public ShopOwner getById(@PathVariable Long id) {
        return service.getShopOwnerById(id);
    }

    @GetMapping
    public List<ShopOwner> getAll() {
        return service.getAllShopOwners();
    }

    @PutMapping("/{id}")
    public ShopOwner update(@PathVariable Long id, @RequestBody ShopOwnerRequest request) {
        ShopOwner owner = new ShopOwner();
        owner.setName(request.getName());
        owner.setDob(request.getDob());
        owner.setAddress(request.getAddress());
        owner.setShopId(request.getShopId());
        return service.updateShopOwner(id, owner);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteShopOwner(id);
        return "Shop Owner deleted successfully";
    }
}
