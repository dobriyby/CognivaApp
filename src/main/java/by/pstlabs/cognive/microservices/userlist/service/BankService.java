package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.userlist.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.Bank;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.repository.BankRepository;
import by.pstlabs.cognive.microservices.userlist.repository.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private ListsRepository listsRepository;

    private final String MSG_BANK_NOT_FOUND = "Bank with id {} not found!";

    private ResourceNotFoundException errBankNotFound(Long bankId) {
        return new ResourceNotFoundException(String.format(MSG_BANK_NOT_FOUND, bankId));
    }

    public List<Bank> getBanks(){
        return bankRepository.findAll();
    }

    public void createList(Long bankId, String listName){
        // TODO which side have to handle bidirectional associations creation?
    }

    public List<Lists> getListsByBankId(Long bankId) throws ResourceNotFoundException {
        return bankRepository.findById(bankId).map((bank -> {
            return new ArrayList<>(bank.getLists());
        })).orElseThrow(() -> errBankNotFound(bankId));
    }

    public Boolean isUserInAnyList(Long bankId, User user) throws ResourceNotFoundException {
        return bankRepository.findById(bankId).map((bank) -> {
            return bank.getLists().stream().anyMatch((list) -> list.getUserSet().contains(user));
        }).orElseThrow(() -> errBankNotFound(bankId));
    }

}
