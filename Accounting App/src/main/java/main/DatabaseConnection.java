package main;


import java.sql.*;

public class DatabaseConnection
{

    public DatabaseConnection()
    {

    }

    /*Creating the main database the idea from boolean type is to check if the database exists
     * or not and based on the true or false take an action */
    private boolean createDatabase()
    {
        boolean checkExistDatabase = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        /*this block is responsible to create the connection based on system vars username and password of the
         * current user so that is why we use System.getenv() methode and query the statement of
         * CREATE DATABASE IF NOT EXISTS MainDataBase to create the main database*/
        try
        {
            String url = "jdbc:mysql://localhost:3306";
            String username = System.getenv ("DB_USERNAME");
            String password = System.getenv ("DB_PASSWORD");
            String creatingDatabase = "CREATE DATABASE IF NOT EXISTS MainDataBase";

            Class.forName ("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection (url, username, password);
            statement = connection.createStatement ( );
            /* here we use the getMetaData sql function to get all database and tables in the schema which are stored in Catalogs
             * after that we use a loop to walk through that Catalogs and get database and table names
             * the indices in database start from 1 not 0 so first index which is the name of
             * database or table will be at index 1*/
            resultSet = connection.getMetaData ( ).getCatalogs ( );
            while (resultSet.next ( ))
            {
                /* here i use the equalsIgnoreCase to ignore case-sensitive to check if database exist and if exist break the loop
                 * and overwrite the value of checkExistDatabase to true and exit the loop */
                if (resultSet.getString (1).equalsIgnoreCase ("MainDataBase"))
                {
                    checkExistDatabase = true;
                    break;  // Database found, no need to continue checking
                }
            }
            /* if checkExistDatabase still false that is mean database doesn't exist and we will create it */
            if (!checkExistDatabase)
            {
                statement.executeUpdate (creatingDatabase);
                creatUserTable ( );
                System.out.println ("Database 'MainDataBase' created successfully with user table .");
            }

        }
        catch (ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace ( );
        }
        /* finally make sure that all connection are closed successfully */
        finally
        {
            try
            {
                if (resultSet != null) resultSet.close ( );
                if (statement != null) statement.close ( );
                if (connection != null) connection.close ( );
            }
            catch (SQLException ex)
            {
                ex.printStackTrace ( );
            }
        }
        return checkExistDatabase;
    }

    /*create users tables for app's users */
    private void creatUserTable()
    {
        boolean created = false;
        String createUserTable = "CREATE TABLE IF NOT EXISTS User (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "username VARCHAR(50) NOT NULL, " +
                "password VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) NOT NULL, " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        if (createDatabase ( ))
        {
            Connection connectToDatabase = connectToDatabase ( );
            Statement statement = null;
            try
            {
                /*check if the table exist or not if it will return false */
                statement = connectToDatabase.createStatement ( );
                ResultSet resultSet = statement.executeQuery ("SHOW TABLES LIKE 'User'");
                if (resultSet.next ( ))
                {
                    System.out.println ("table is exist");
                }
                else
                {
                    statement = connectToDatabase.createStatement ( );
                    statement.execute (createUserTable);
                    System.out.println ("User table created successfully.");
                    created = true;
                }

            }
            catch (SQLException e)
            {
                throw new RuntimeException (e);
            }
            finally
            {
                // Close resources to avoid memory leaks
                try
                {
                    if (statement != null) statement.close ( );
                    if (connectToDatabase != null) connectToDatabase.close ( );
                }
                catch (SQLException e)
                {
                    e.printStackTrace ( );
                }
            }
        }
        else
        {
            System.out.println ("Database does not exist. Table creation skipped.");
        }
    }

    /* create a connect method to connect to database in case creating the structure of the database
     * such as creating tables and other purposes the type of method will be Connection to return the connection to database*/
    private Connection connectToDatabase()
    {
        String url = "jdbc:mysql://localhost:3306/MainDataBase";
        String username = System.getenv ("DB_USERNAME");
        String password = System.getenv ("DB_PASSWORD");
        Connection connection = null;
        try
        {
            Class.forName ("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace ( );

        }
        try
        {
            connection = DriverManager.getConnection (url, username, password);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace ( );

        }
        return connection;

    }

    /* here we use public wrapper to call the private method */
    public boolean initializeDatabase()
    {
        if(connectToDatabase () != null)
        {

        }

        return createDatabase ( );
    }

    /* store data in user table which will be username and email and password for every user */
    public void insertFirstTime(String username, String password, String email)
    {
        /* SQL query */
        String insertUserSQL = "INSERT INTO User (username, password, email) VALUES (?, ?, ?)";
        try
        {
            /* open connection and apply the insertion using preparedStatement */
            Connection connection = connectToDatabase ( );
            PreparedStatement preparedStatement = connection.prepareStatement (insertUserSQL);
            preparedStatement.setString (1, username);
            preparedStatement.setString (2, password);
            preparedStatement.setString (3, email);
            /* to determine if data store successfully because it will return 1 mean that one column affected by
             * the insertion process if it returns 0 mean failed to insert data */
            int affectedRow = preparedStatement.executeUpdate ( );
            if (affectedRow > 0)
            {
                System.out.println ("User inserted successfully.");

            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException (e);
        }


    }
}
