package com.ecommerce.QuickShop.Service;

import com.ecommerce.QuickShop.Exception.ProductNotFoundException;

public interface ItemService {

    public String viewItem(int productId) throws ProductNotFoundException;
}
