package anishaKumari.restAPI_expense_app.customException;

public class CategoryNotFound extends RuntimeException{

    public CategoryNotFound(String category)
    {
        super("Category not found Exception: " + category);
    }
}
