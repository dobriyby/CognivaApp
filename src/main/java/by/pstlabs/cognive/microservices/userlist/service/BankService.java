package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.microservices.userlist.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.Bank;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public List<Bank> getBanks(){
        return bankRepository.findAll();
    }

    public List<Lists> getListsByBankId(Long bankId) throws ResourceNotFoundException {
        return bankRepository.findById(bankId).map((bank -> {
            return new ArrayList<>(bank.getLists());
        })).orElseThrow(() -> new ResourceNotFoundException("bank not found!"));
    }

}
