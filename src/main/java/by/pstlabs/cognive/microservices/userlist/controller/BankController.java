package by.pstlabs.cognive.microservices.userlist.controller;

import by.pstlabs.cognive.microservices.userlist.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.Bank;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getAllBanks(){
        List<Bank> bankList = bankService.getBanks();
        return new ResponseEntity<>(bankList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/banks/{bankId}/lists")
    public ResponseEntity<List<Lists>> getAllListsByBankId(
            @PathVariable(value = "bankId") Long bankId) throws ResourceNotFoundException{
        return new ResponseEntity<>(bankService.getListsByBankId(bankId), new HttpHeaders(), HttpStatus.OK);
    }

}
