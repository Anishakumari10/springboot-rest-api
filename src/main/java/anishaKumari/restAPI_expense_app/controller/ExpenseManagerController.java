package anishaKumari.restAPI_expense_app.controller;

import anishaKumari.restAPI_expense_app.dto.ExpenseDTO;
import anishaKumari.restAPI_expense_app.io.ExpenseResponse;
import anishaKumari.restAPI_expense_app.service.impl.ExpenseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ExpenseManagerController {

    private final ExpenseServiceImpl expenseServiceImpl;
    private final ModelMapper modelMapper;

    @GetMapping("/getAllExpenses")
    public List<ExpenseResponse> getAllExpense(){

        //Call the service Impl for getting all expenses
        List<ExpenseDTO> allExpenses = expenseServiceImpl.getAllExpenses();
        //Convert ExpenseDTO to Expense Response
        //Return expense list
        return allExpenses.stream().map(expenseDTO -> modelMapper.map(expenseDTO, ExpenseResponse.class)).collect(Collectors.toList());
    }

    @GetMapping("/getExpense/{category}")
    public List<ExpenseResponse> getExpenseByCategory(@RequestParam String category){
        List<ExpenseDTO> expenseByCategory = expenseServiceImpl.getExpenseByCategory(category);
        return expenseByCategory.stream().map(expenseDTO -> modelMapper.map(expenseDTO, ExpenseResponse.class)).collect(Collectors.toList());

    }
}
