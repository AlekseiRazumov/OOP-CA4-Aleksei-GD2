package com.dkit.oop.sd2.DTOs;



public class Expense
{
    private int expenseID;
    private String title;
    private String category;
    private double amount;
    private String date;

    public Expense(int expenseID, String title, String category, double amount, String date)
    {
        this.expenseID = expenseID;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public Expense(String title, String category, double amount, String date)
    {
        this.expenseID = 0;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public Expense()
    {
    }

    public int getExpenseID()
    {
        return expenseID;
    }

    public void setExpenseID(int expenseID)
    {
        this.expenseID = expenseID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Expense{" + "expenseID=" + expenseID + ", title=" + title + ", category=" +
                category + ", amount=" + amount + ", date=" + date + '}';
    }

}
