package anishaKumari.restAPI_expense_app.service.impl;

import anishaKumari.restAPI_expense_app.dto.ExpenseDTO;
import anishaKumari.restAPI_expense_app.expenseEntity.ExpenseEntity;
import anishaKumari.restAPI_expense_app.respository.ExpenseRepository;
import anishaKumari.restAPI_expense_app.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ExpenseDTO> getAllExpenses() {

        //Get all expenses from repository
        List<ExpenseEntity> entityList = expenseRepository.findAll();
        //Convert Entity to DTO
        //return the list
        return entityList.stream().map(expenseEntity -> modelMapper.map(expenseEntity,ExpenseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseDTO> getExpenseByCategory(String category) {
        List<ExpenseEntity> byCategory= expenseRepository.findByCategory(category);
        return byCategory.stream().map(expenseEntity -> modelMapper.map(expenseEntity, ExpenseDTO.class)).collect(Collectors.toList());

    }


//    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
//        return modelMapper.map(expenseEntity,ExpenseDTO.class);
//
//    }
}
