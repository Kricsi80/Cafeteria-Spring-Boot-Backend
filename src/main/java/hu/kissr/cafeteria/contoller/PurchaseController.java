package hu.kissr.cafeteria.contoller;

import hu.kissr.cafeteria.service.PurchaseService;
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
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @RequestMapping(value = "/{id}", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createPurchase(@PathVariable Long id) throws URISyntaxException {
        Integer result = purchaseService.createPurchase(id);
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
