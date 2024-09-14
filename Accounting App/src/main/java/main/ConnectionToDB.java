package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB
{
    private String dir;
    private final String dbFileName = "nasser.db";

    public String getDir()
    {
        return dir;
    }

    public void setDir(String dir)
    {
        this.dir = dir;
    }
    public String getDbFilePath() {
        return dir + "/" + dbFileName; // Return the full path to the database file
    }

    public boolean createDirectory(String directoryPath)
    {
        Path path = Paths.get (directoryPath);

        try
        {
            // Attempt to create directories
            Files.createDirectories (path);
            setDir (directoryPath);
            // Check if the directory exists after the attempt
            return Files.exists (path); // true if exists, false otherwise

        }
        catch (IOException ex)
        {
            ex.printStackTrace ();
            return false; // Return false if an exception occurs
        }
    }

    public void connecting()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection ("jdbc:sqlite:" + getDbFilePath ());
            System.out.println ("Connection to SQLite has been established.");
        }
        catch (SQLException e)
        {
            throw new RuntimeException (e);
        }
        finally
        {
            try
            {
                if (conn != null)
                {
                    conn.close ();
                }
            }
            catch (SQLException ex)
            {
                System.out.println (ex.getMessage ());
            }

        }
    }
    }





