package anishaKumari.restAPI_expense_app.respository;

import anishaKumari.restAPI_expense_app.expenseEntity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {

    List<ExpenseEntity> findByCategory(String category);

}
