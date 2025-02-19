package com.dkit.oop.sd2.DAOs;



import com.dkit.oop.sd2.DTOs.Income;
import com.dkit.oop.sd2.DTOs.Expense;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.util.List;

public interface DaoInterface
{
    public List<Expense> findAllExpenses() throws DaoException;
    public double totalExpenses() throws DaoException;
    public List<Income> findAllIncomes() throws DaoException;
    public double totalIncomes() throws DaoException;
    public void addExpense(String title, String category,double amount, String date) throws DaoException;
    public void addIncome(String title, double amount, String date) throws DaoException;
    public void deleteExpenseById(int id) throws DaoException;
    public void deleteIncomeById(int id) throws DaoException;
    public void findAllIncomesAndExpensesByMonth(String month) throws DaoException;


}

