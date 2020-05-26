package net.frank.corejava2.ch04;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class ExecSQL {
    interface PreparedFile{
        String Books = "Books.sql";
        String Authors = "Authors.sql";
        String Publishers = "Publishers.sql";
        String BooksAuthors = "BooksAuthors.sql";
    }
    public static void main(String[] args){
        //File f = new File("./");
        //System.out.println(f.getAbsolutePath());
        String folder = "demos/demos-javacore-phase2/src/main/resources/ch04/";
        innerMain(folder + PreparedFile.Books);
        innerMain(folder + PreparedFile.Authors);
        innerMain(folder + PreparedFile.Publishers);
        innerMain(folder + PreparedFile.BooksAuthors);
    }

    private static void innerMain(String file){
        try{
            Scanner in = new Scanner(new File(file));
            Connection conn = getConnection();
            try{
                Statement stat = conn.createStatement();
                while(true){
                    if(!in.hasNextLine()){
                        return;
                    }
                    String line = in.nextLine();
                    if(line.equalsIgnoreCase("EXIT")){
                        return;
                    }
                    //if(line.trim().endsWith(";")){
                    line = line.trim();
                        //line = line.substring(0,line.length()-1);
                    //}
                    //System.out.println("Execute SQL -> " + line);
                    try{
                        boolean hasResultSet = stat.execute(line);
                        if(hasResultSet){
                            showResultSet(stat);
                        }
                    }catch (SQLException e){
                        for(Throwable t:e){
                            t.printStackTrace();
                        }
                    }
                }
            }finally {
                conn.close();
            }
        }catch (SQLException e){
            for(Throwable t: e){
                t.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException,IOException{
        Properties props = new Properties();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
        props.load(in);
        in.close();

        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null){
            System.setProperty("jdbc.drivers",drivers);
        }
        String url = props.getProperty("jdbc.url");

        return DriverManager.getConnection(url);

    }

    private static void showResultSet(Statement stat)throws SQLException{
        ResultSet result = stat.getResultSet();
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();

        for(int i=1;i<=columnCount;i++){
            if(i>1){
                System.out.print(", ");
            }
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();

        while (result.next()){
            for(int i=1;i<=columnCount;i++){
                if(i>1){
                    System.out.print(",");
                }
                System.out.print(result.getString(i));
            }
            System.out.println();
        }
        result.close();
    }

}
