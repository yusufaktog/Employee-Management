
package company;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WorkerOperations {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pStatement = null;

    public WorkerOperations() {
        String url = "jdbc:mysql://"+DataBase.HOST+":"+"/"+DataBase.DB_NAME;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException ex ){
            
        }
        try {
            connection = DriverManager.getConnection(url,DataBase.USERNAME,DataBase.PASSWORD);
            //System.out.println("Connection Successfull");
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Worker> getWorkers(){
        ArrayList<Worker> workers = new ArrayList<>();
        
        try {
            pStatement = connection.prepareStatement("SELECT * FROM workers");
            ResultSet rs = pStatement.executeQuery();
            while(rs.next()){
                workers.add(new Worker(rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("department"),rs.getString("salary")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return workers;
    }
    public void addWorker(String name,String surname,String department,String salary) throws SQLException{
        String query  = "INSERT INTO workers(name,surname,department,salary) VALUES(?,?,?,?)";
        //String query = "UPDATE workers SET email = 'example.gmail.com' where id = 1";
        
        pStatement = connection.prepareStatement(query);
        pStatement.setString(1, name);
        pStatement.setString(2, surname);
        pStatement.setString(3, department);
        pStatement.setString(4, salary);
        pStatement.executeUpdate();
        
        
    }
    public void deleteWorker(Integer id){
        String query = "DELETE FROM workers WHERE id = ? ";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1,id);
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateWorker(Integer id,String name,String surname,String department,String salary){
        try {
            String query = "UPDATE workers SET name = ? , surname = ? , department = ? , salary = ? where id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, name);
            pStatement.setString(2, surname);
            pStatement.setString(3, department);
            pStatement.setString(4, salary);
            pStatement.setInt(5, id);
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean login(String userName,String password){
        String query = "SELECT * FROM admins where username = ? and password = ?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, userName);
            pStatement.setString(2, password);
            ResultSet rs = pStatement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public static void main(String[] args) {
        WorkerOperations w = new WorkerOperations();
        
    }
    
    
}
