package anishaKumari.restAPI_expense_app.service;

import anishaKumari.restAPI_expense_app.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDTO> getAllExpenses();

    List<ExpenseDTO> getExpenseByCategory(String category);
}
