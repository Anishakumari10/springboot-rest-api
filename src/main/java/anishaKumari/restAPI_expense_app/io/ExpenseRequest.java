package anishaKumari.restAPI_expense_app.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {

    private String name;

    private String category;

    private String note;

    private BigDecimal amount;

    private Date date;


}
