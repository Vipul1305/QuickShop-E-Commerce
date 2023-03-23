package com.ecommerce.QuickShop.Repository;

import com.ecommerce.QuickShop.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    @Query(value = "select s.seller_id from seller s", nativeQuery = true)
    List<Integer> findAllSellerId();
}
