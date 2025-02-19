package com.dkit.oop.sd2.DAOs;



import com.dkit.oop.sd2.DTOs.Expense;
import com.dkit.oop.sd2.DTOs.Income;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlExpenseAndIncomeDao extends MySqlDao implements UserDaoInterface {

    @Override
    public List<Expense> findAllExpenses() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Expense> expensesList = new ArrayList<>();

        try {
            //Get connection object using the getConnection() method inherited
            // from the super class (MySqlDao.java)
            connection = this.getConnection();

            String query = "SELECT * FROM EXPENSES";
            preparedStatement = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int expenseID = resultSet.getInt("expenseID");
                String title = resultSet.getString("title");
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("dateIncurred");
                Expense u = new Expense(expenseID,  title, category, amount, date);
                expensesList.add(u);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllExpensesResultSet() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllExpense() " + e.getMessage());
            }
        }
        return expensesList;     // may be empty
    }
    @Override
    public double totalExpenses() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        double total=0;

        try {
            //Get connection object using the getConnection() method inherited
            // from the super class (MySqlDao.java)
            connection = this.getConnection();

            String query = "SELECT * FROM EXPENSES";
            preparedStatement = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double amount = resultSet.getDouble("amount");
                total+=amount;

            }
        } catch (SQLException e) {
            throw new DaoException("totalExpenses() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("totalExpenses() " + e.getMessage());
            }
        }
        return total;     // may be empty
    }
    @Override
    public List<Income> findAllIncomes() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Income> incomesList = new ArrayList<>();

        try {
            //Get connection object using the getConnection() method inherited
            // from the super class (MySqlDao.java)
            connection = this.getConnection();

            String query = "SELECT * FROM INCOMES";
            preparedStatement = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int incomeID = resultSet.getInt("incomeID");
                String title = resultSet.getString("title");

                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("dateEarned");
                Income u = new Income(incomeID,  title, amount, date);
                incomesList.add(u);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllIncomesResultSet() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllIncomes() " + e.getMessage());
            }
        }
        return incomesList;     // may be empty
    }
    @Override
    public double totalIncomes() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        double total=0;

        try {
            //Get connection object using the getConnection() method inherited
            // from the super class (MySqlDao.java)
            connection = this.getConnection();

            String query = "SELECT * FROM INCOMES";
            preparedStatement = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double amount = resultSet.getDouble("amount");
                total+=amount;

            }
        } catch (SQLException e) {
            throw new DaoException("totalIncomes() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("totalIncomes() " + e.getMessage());
            }
        }
        return total;     // may be empty
    }
    @Override
    public void addExpense(String title, String category,double amount, String date) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Expense expense = null;
        try {
            connection = this.getConnection();

            String query = "INSERT INTO EXPENSES (expenseID,title,category,amount, dateIncurred) VALUES (null,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, category);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setString(4,date);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("addExpense() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("addExpense() " + e.getMessage());
            }
        }

    }
    @Override
    public void addIncome(String title, double amount, String date) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Income income = null;
        try {
            connection = this.getConnection();

            String query = "INSERT INTO INCOMES (incomeID,title,amount, dateEarned) VALUES (null,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);

            preparedStatement.setDouble(2, amount);
            preparedStatement.setString(3,date);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("addIncome() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("addIncome() " + e.getMessage());
            }
        }

    }
    @Override
    public void deleteExpenseById(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.getConnection();

            String query = "DELETE FROM EXPENSES WHERE expenseID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("deleteExpenseById() " + e.getMessage());
        }
    }
    @Override
    public void deleteIncomeById(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.getConnection();

            String query = "DELETE FROM INCOMES WHERE incomeID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("deleteIncomeById() " + e.getMessage());
        }
    }
}

