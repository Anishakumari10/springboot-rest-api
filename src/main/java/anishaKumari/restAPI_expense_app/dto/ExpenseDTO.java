package anishaKumari.restAPI_expense_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseDTO {

    private String expenseId;

    private String name;

    private String category;

    private String note;

    private BigDecimal amount;

    private Date date;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
