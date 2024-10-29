package anishaKumari.restAPI_expense_app.controller;

import anishaKumari.restAPI_expense_app.customException.CategoryNotFound;
import anishaKumari.restAPI_expense_app.dto.ExpenseDTO;
import anishaKumari.restAPI_expense_app.expenseEntity.ExpenseEntity;
import anishaKumari.restAPI_expense_app.io.ExpenseResponse;
import anishaKumari.restAPI_expense_app.service.impl.ExpenseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ExpenseManagerController {

    private final ExpenseServiceImpl expenseServiceImpl;
    private final ModelMapper modelMapper;

    @GetMapping("/getAllExpenses")
    public List<ExpenseResponse> getAllExpense(){

        //Call the service Impl for getting all expenses
        List<ExpenseDTO> allExpenses = expenseServiceImpl.getAllExpenses();
        //Convert ExpenseDTO to Expense Response
        //Return expense list
        log.info("Getting all expenses");
        return allExpenses.stream()
                .map(expenseDTO -> modelMapper.map(expenseDTO, ExpenseResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/getExpense")
    public List<ExpenseResponse> getExpenseByCategory(@RequestParam String category){

        List<ExpenseDTO> expenseByCategory = expenseServiceImpl.getExpenseByCategory(category);
        if(expenseByCategory.isEmpty()){
            throw new CategoryNotFound(category);
        }
        return expenseByCategory.stream().map(expenseDTO -> modelMapper.map(expenseDTO, ExpenseResponse.class)).collect(Collectors.toList());

    }
}
