package anishaKumari.restAPI_expense_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class expenseMangerController {
    @GetMapping("/hello")
    public String sayHello() {
        return "something!!";
    }
}
