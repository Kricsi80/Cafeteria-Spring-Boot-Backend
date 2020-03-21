package hu.kissr.cafeteria.contoller;


import hu.kissr.cafeteria.model.PurchaseHasProduct;
import hu.kissr.cafeteria.service.PurchaseHasProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@RequestMapping("/php")
public class PurchaseHasProductController {

    @Autowired
    PurchaseHasProductService php;

    @RequestMapping(value = "/{purchaseId}/{productId}/{amount}/{purchasePriceTotal}", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PurchaseHasProduct> createPurchaseHasProduct(@PathVariable Long purchaseId,
                                                                       @PathVariable Long productId,
                                                                       @PathVariable int amount,
                                                                       @PathVariable int purchasePriceTotal) throws URISyntaxException {
        PurchaseHasProduct result = php.createPurchaseHasProduct(productId, amount, purchaseId, purchasePriceTotal);
        return new ResponseEntity<PurchaseHasProduct>(result, HttpStatus.OK);
    }
}

