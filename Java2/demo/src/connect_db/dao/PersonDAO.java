package connect_db.dao;

import connect_db.model.Person;
import connect_db.model.PersonDTO;
import connect_db.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<Person> getAllPersons() {
        List<Person> list = new ArrayList<>();
        try {
            //ClassName.staticMethod
            Connection conn = DBUtil.getMySqlConnection();

            //3. Create statement
            Statement stmt = conn.createStatement();

            //4. Execute
            ResultSet rs = stmt.executeQuery("SELECT Personid, LastName, FirstName, Age FROM Persons");

            while(rs.next()) {
                int id = rs.getInt(1);
                String lName = rs.getString(2);
                String fName = rs.getString(3);
                int age = rs.getInt(4);

                list.add(new Person(id, lName, fName, age));
            }
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public boolean updateNewPerson(Person person)  {
        //"UPDATE Persons SET LastName = ? , FirstName = ? , Age = ? WHERE Personid = ?";
        try {
            Connection conn = DBUtil.getMySqlConnection();

            //use PreparedStatement to insert new Person into DB
            PreparedStatement preparedStatement
                    = conn.prepareStatement("UPDATE persons SET LastName = ? , FirstName = ? , Age = ? WHERE Personid = ?"); // Place holder

            preparedStatement.setString(1, person.getlName());
            preparedStatement.setString(2, person.getfName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setInt(4, person.getPersonId());

            int result = preparedStatement.executeUpdate();

            if(result > 0) {
                conn.close();
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean insertNewPerson(Person person)  {
        try {
            Connection conn = DBUtil.getMySqlConnection();

            //use PreparedStatement to insert new Person into DB
            PreparedStatement preparedStatement
                    = conn.prepareStatement("INSERT INTO persons(LastName, FirstName, Age) " +
                    " VALUE (?,?,?)"); // Place holder

            preparedStatement.setString(1, person.getlName());
            preparedStatement.setString(2, person.getfName());
            preparedStatement.setInt(3, person.getAge());

            int result = preparedStatement.executeUpdate();

            if(result > 0) {
                conn.close();
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }


    public Person getPersonById(int id) {
        try {
            Connection conn = DBUtil.getMySqlConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT `Personid`, `LastName`, `FirstName`, `Age` FROM `persons` WHERE Personid = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs != null && rs.next()) {
                int pId = rs.getInt("Personid");
                String lName = rs.getString("LastName");
                String fName = rs.getString("FirstName");
                int age = rs.getInt("Age");
                conn.close();
                return new Person(pId, lName,fName,age);
            } else {
                System.out.println("Does not exist !");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public List<Person> getPersonByName(String name) {
        List<Person> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getMySqlConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT `Personid`, `LastName`, `FirstName`, `Age` FROM `persons` WHERE `LastName` = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int pId = rs.getInt("Personid");
                    String lName = rs.getString("LastName");
                    String fName = rs.getString("FirstName");
                    int pAge = rs.getInt("Age");
                    list.add(new Person(pId, lName, fName, pAge));
                }
                conn.close();
            } else {
                System.out.println("Does not exist !");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean deletePersonById(int id) {
        try {
            Connection conn = DBUtil.getMySqlConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM `persons` WHERE `Personid` = ?");
            stmt.setInt(1, id);
            int rowAffected = stmt.executeUpdate();
            return rowAffected > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<PersonDTO> getTableInnerJoin() {
        List<PersonDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getMySqlConnection();
            CallableStatement call = conn.prepareCall("{call getOrders}");
            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                int personID = rs.getInt("PersonID");
                String lName = rs.getString("LastName");
                int orderNumber = rs.getInt("orderNumber");

                list.add(new PersonDTO(personID, lName, orderNumber));
            }

            conn.close();
            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


}
