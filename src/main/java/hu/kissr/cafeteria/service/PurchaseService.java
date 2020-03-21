package hu.kissr.cafeteria.service;

import hu.kissr.cafeteria.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public Integer createPurchase(Long employeeId) {

        return purchaseRepository.createPurchase(employeeId);
    }
}
