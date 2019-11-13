package main.org.application;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCustomerImpl implements ServiceCustomer {
    private String url = "jdbc:mysql://localhost/human?serverTimezone=UTC&useSSL=false";
    private String name = "root";
    private String password = "ironman2019";

    protected String getUrl() {
        return url;
    }
    protected String getName() {
        return name;
    }
    protected String getPassword() {
        return password;
    }


    @Override
    public String addCustomer(int id, String surname, String first_name) {
        try (Connection con = DriverManager.getConnection(url, name, password)) {
            Statement statement = con.createStatement();
            StringBuffer ins = new StringBuffer("Insert into customer Values ( ");
            ins.append(id);
            ins.append(", '");
            ins.append(surname);
            ins.append("','");
            ins.append(first_name);
            ins.append("')");
            statement.executeUpdate(String.valueOf(ins));
            return "Passenger was added";
        } catch (SQLException e) {
            return "Passenger wasn't added";
        }
    }

    @Override
    public String getSurname(int id) {
        return null;
    }

    @Override
    public String findCustomer(String nameOfPass) {
        String request = "select * from customer";
        List<String> aaa = new ArrayList<>();
        int index = -1;

        try (Connection con = DriverManager.getConnection(url, name, password)) {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                String cust = resultSet.getString(1);
                String cust1 = resultSet.getString(2);
                String cust2 = resultSet.getString(3);
                String info = cust + " " + cust1 + " " + cust2;
                aaa.add(info);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String s=null;
        for (String a: aaa){
            index = a.indexOf(nameOfPass);
            if (index != -1)
                s = a;
        }
        if (s==null){
            System.out.println("Попробуйте еще раз");
            return "Попробуйте еще раз";
        }
        else {
            System.out.println(s);
            return s;
        }
    }
}
