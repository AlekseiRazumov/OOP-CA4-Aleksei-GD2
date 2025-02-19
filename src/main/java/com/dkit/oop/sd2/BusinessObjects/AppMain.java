package com.dkit.oop.sd2.BusinessObjects;



import com.dkit.oop.sd2.DAOs.MySqlExpenseAndIncomeDao;
import com.dkit.oop.sd2.DAOs.DaoInterface;
import com.dkit.oop.sd2.DTOs.Expense;
import com.dkit.oop.sd2.DTOs.Income;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.util.List;

public class AppMain
{
    public static void main(String[] args)
    {
        DaoInterface IDao = new MySqlExpenseAndIncomeDao();

        try
        {
            System.out.println("\nCall findAllExpenses()");
            List<Expense> expenses = IDao.findAllExpenses();

            if( expenses.isEmpty() )
                System.out.println("There are no expenses");
            else {
                for (Expense expense : expenses)
                    System.out.println("Expense: " + expense.toString());
            }

            System.out.println("\nCall totalExpenses()");
            System.out.println("Total expenses: "+ IDao.totalExpenses());


            System.out.println("\nCall findAllIncomes()");
            List<Income> incomes = IDao.findAllIncomes();

            if( incomes.isEmpty() )
                System.out.println("There are no incomes");
            else {
                for (Income income : incomes)
                    System.out.println("Income: " + income.toString());
            }

            System.out.println("\nCall totalIncomes()");
            System.out.println("Total incomes: "+ IDao.totalIncomes());

            System.out.println("\nCall addExpenses()");
            String title = "Flight ticket";
            String category = "Travel";
            double amount = 56.68;
            String dateIncurred = "2025-02-26";
            IDao.addExpense(title,category,amount,dateIncurred);
            expenses = IDao.findAllExpenses();
            if( expenses.isEmpty() )
                System.out.println("There are no expenses");
            else {
                for (Expense expense : expenses)
                    System.out.println("Expense: " + expense.toString());
            }

            System.out.println("\nCall deleteExpenseById()");
            int id=6;
            IDao.deleteExpenseById(id);
            expenses = IDao.findAllExpenses();
            if( expenses.isEmpty() )
                System.out.println("There are no expenses");
            else {
                for (Expense expense : expenses)
                    System.out.println("Expense: " + expense.toString());
            }


            System.out.println("\nCall addIncome()");
            title = "Delivery";
            amount = 120.8;
            String dateEarned = "2025-01-21";
            IDao.addIncome(title,amount,dateEarned);
            incomes = IDao.findAllIncomes();
            if( incomes.isEmpty() )
                System.out.println("There are no incomes");
            else {
                for (Income income : incomes)
                    System.out.println("Income: " + income.toString());
            }

            System.out.println("\nCall deleteIncomeById()");
            id=3;
            IDao.deleteIncomeById(id);
            incomes = IDao.findAllIncomes();
            if( incomes.isEmpty() )
                System.out.println("There are no incomes");
            else {
                for (Income income : incomes)
                    System.out.println("Income: " + income.toString());
            }

            System.out.println("\nCall findAllIncomesAndExpensesByMonth()");
            IDao.findAllIncomesAndExpensesByMonth("January");
        }
        catch( DaoException e )
        {
            /// This code is executed when the DAO layer throws an exception.
            /// We might place some logic here to deal with the issue, but in this case,
            /// we simply print out the exception error message to the console.
            e.printStackTrace();
        }
    }
}
