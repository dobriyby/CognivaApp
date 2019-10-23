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
    private ListsService listsService;

    public List<Bank> getBanks(){
        return bankRepository.findAll();
    }

    public Lists createList(Long bankId, String listName) throws ResourceNotFoundException {
        Lists lists = listsService.createLists(listName);
        return bankRepository.findById(bankId).map((bank) -> {
            bank.addLists(lists);
            bankRepository.save(bank);
            return lists;
        }).orElseThrow(() -> new ResourceNotFoundException("bank", bankId));
    }

    public List<Lists> getListsByBankId(Long bankId) throws ResourceNotFoundException {
        return bankRepository.findById(bankId).map((bank -> {
            return new ArrayList<>(bank.getLists());
        })).orElseThrow(() -> new ResourceNotFoundException("bank", bankId));
    }

    public Boolean isUserInAnyList(Long bankId, User user) throws ResourceNotFoundException {
        return bankRepository.findById(bankId).map((bank) -> {
            return bank.getLists().stream().anyMatch((list) -> list.getUserSet().contains(user));
        }).orElseThrow(() -> new ResourceNotFoundException("bank", bankId));
    }

}
