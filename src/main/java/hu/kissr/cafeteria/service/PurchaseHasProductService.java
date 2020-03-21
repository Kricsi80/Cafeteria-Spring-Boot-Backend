package hu.kissr.cafeteria.service;

import hu.kissr.cafeteria.model.PurchaseHasProduct;
import hu.kissr.cafeteria.repository.PurchaseHasProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseHasProductService {

    @Autowired
    PurchaseHasProductRepository purchaseHasProductRepository;

    public PurchaseHasProduct createPurchaseHasProduct(
        Long productId,
        int amount,
        Long purchaseId,
        int purchasePriceTotal) {
        PurchaseHasProduct php = new PurchaseHasProduct();
        php.setProductId(productId);
        php.setAmount(amount);
        php.setPurchaseId(purchaseId);
        php.setPurchasePriceTotal(purchasePriceTotal);

        return purchaseHasProductRepository.save(php);
    }
}
