package com.dkit.oop.sd2.BusinessObjects;



import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.DTOs.Expense;
import com.dkit.oop.sd2.DTOs.Income;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.util.List;

public class AppMain
{
    public static void main(String[] args)
    {
        UserDaoInterface IUserDao = new MySqlUserDao();  //"IUserDao" -> "I" stands for Interface

        /// Notice that the userDao reference is an Interface type.
        /// This allows for the use of different concrete implementations.
        /// e.g. we could replace the MySqlUserDao with an OracleUserDao
        /// (accessing an Oracle Database)
        /// without changing anything in the Interface.
        /// If the Interface doesn't change, then none of the
        /// code in this file that uses the interface needs to change.
        /// This code is dependent of the Interface but not on the implementation
        /// of the interface.
        /// The 'contract' defined by the interface will not be broken.
        /// This means that this code is 'independent' of the code
        /// used to access the database. (Reduced coupling).

        /// The Business Objects require that all User DAOs implement
        /// the interface called "UserDaoInterface", as the code uses
        /// only references of the interface type to access the DAO methods.

        try
        {
            System.out.println("\nCall findAllUsers()");
            List<Expense> expenses = IUserDao.findAllUsers();     // call a method in the DAO

            if( expenses.isEmpty() )
                System.out.println("There are no Users");
            else {
                for (Expense expense : expenses)
                    System.out.println("Expense: " + expense.toString());
            }

            // test dao with a username and password that we know are present in the database
            // (Use phpMyAdmin to check that the database has a row with this data)
            System.out.println("\nCall: findUserByUsernamePassword()");
            String username = "smithj";
            String password = "password";

            User user = IUserDao.findUserByUsernamePassword(username, password);

            if( user != null ) // null returned if userid and password not valid
                System.out.println("User found: " + user);
            else
                System.out.println("Username with that password not found");

            // test dao - with an invalid username (i.e. row not in database)
            username = "madmax";
            password = "thunderdome";

            user = IUserDao.findUserByUsernamePassword(username, password);

            if(user != null)
                System.out.println("Username: " + username + " was found: " + user);
            else
                System.out.println("Username: " + username + ", password: " + password +" : NO match found");
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
