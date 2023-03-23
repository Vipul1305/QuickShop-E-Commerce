package com.ecommerce.QuickShop.Repository;

import com.ecommerce.QuickShop.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
