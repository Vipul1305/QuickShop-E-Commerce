package com.ecommerce.QuickShop.Service.Impl;

import com.ecommerce.QuickShop.Exception.ProductNotFoundException;
import com.ecommerce.QuickShop.Model.Item;
import com.ecommerce.QuickShop.Model.Product;
import com.ecommerce.QuickShop.Repository.ProductRepository;
import com.ecommerce.QuickShop.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public String viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try {
            product = productRepository.findById(productId).get();
        }catch (Exception e){
            throw new ProductNotFoundException("Product Not Found");
        }
        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();
        //map item to product
        product.setItem(item);

        productRepository.save(product);

        return "Item got viewed";
    }
}
