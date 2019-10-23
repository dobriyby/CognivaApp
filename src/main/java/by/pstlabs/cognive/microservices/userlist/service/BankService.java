package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.common.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.Bank;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService extends BaseService<Bank> {

    @Autowired
    private ListsService listsService;

    public Lists createList(Long bankId, String listName) throws ResourceNotFoundException {
        Lists lists = listsService.create(new Lists(listName));
        return repository.findById(bankId).map((bank) -> {
            bank.addLists(lists);
            repository.save(bank);
            return lists;
        }).orElseThrow(() -> new ResourceNotFoundException("bank", bankId));
    }

    public List<Lists> getListsByBankId(Long bankId) throws ResourceNotFoundException {
        return repository.findById(bankId).map((bank -> {
            return new ArrayList<>(bank.getLists());
        })).orElseThrow(() -> new ResourceNotFoundException("bank", bankId));
    }

    public Boolean isUserInAnyList(Long bankId, User user) throws ResourceNotFoundException {
        return repository.findById(bankId).map((bank) -> {
            return bank.getLists().stream().anyMatch((list) -> list.getUserSet().contains(user));
        }).orElseThrow(() -> new ResourceNotFoundException("bank", bankId));
    }

}
