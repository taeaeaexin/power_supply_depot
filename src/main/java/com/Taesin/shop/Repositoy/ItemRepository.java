package com.Taesin.shop.Repositoy;

import com.Taesin.shop.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}