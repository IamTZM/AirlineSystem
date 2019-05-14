package com.dbexp.sample.controller;

import com.dbexp.access.Conn;
import com.dbexp.dao.Ticket;
import com.dbexp.sample.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import com.dbexp.access.Conn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @Author: Steph
 * @Date: 2019/5/12
 */
public class ManageController implements Initializable {

    @FXML
    private TableView<Ticket> table;

    @FXML
    private TableColumn<Ticket, String> fid;
    @FXML
    private TableColumn<Ticket, String> oplace;
    @FXML
    private TableColumn<Ticket, String> tplace;
    @FXML
    private TableColumn<Ticket, String> fdate;
    @FXML
    private TableColumn<Ticket, String> otime;
    @FXML
    private TableColumn<Ticket, String> ttime;
    @FXML
    private TableColumn<Ticket, String> remainder;
    @FXML
    private TableColumn<Ticket, String> price;
    @FXML
    private TableColumn<Ticket, String> dcnt;
    @FXML
    private TableColumn<Ticket, String> drate;
    @FXML
    private TableColumn<Ticket, String> comp;
    @FXML
    private TextField flight_no;
    @FXML
    private DatePicker flight_date;

    private Main application;

    // define DateFormat
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void setApp(Main application){
        this.application = application;
    }

    private void insertData2Table(ResultSet rs, ObservableList<Ticket> list) throws SQLException {
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setFid(rs.getString("FID"));
            ticket.setOplace(rs.getString("ORIGIN_PLACE"));
            ticket.setTplace(rs.getString("TEMINAL_PLACE"));
            ticket.setFdate(sdf.format(rs.getDate("FDATE")));
            ticket.setOtime(rs.getString("ORIGIN_TIME"));
            ticket.setTtime(rs.getString("TEMINAL_TIME"));
            ticket.setRemainder(rs.getString("REMAINDER"));
            ticket.setPrice(rs.getString("PRICE"));
            ticket.setDcnt(rs.getString("DISCOUNT_CNT"));
            ticket.setDrate(rs.getString("DISCOUNT_RATE"));
            ticket.setComp(rs.getString("COMPANY"));
            list.add(ticket);
            table.setEditable(true);
            table.setItems(list);
        }
    }

    @FXML
    private void OUT_M(ActionEvent event) {
        application.gotoHome();
    }

    @FXML
    private void QUERY_M(ActionEvent event) {
        String fid_str = flight_no.getText();
        String fdate_str = flight_date.getValue().toString();
        table.setItems(FXCollections.observableArrayList());
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Conn.DB_URL, Conn.USER, Conn.PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // execute sql
            StringBuilder sql = new StringBuilder("SELECT * FROM FLIGHT WHERE FID = '");
            sql.append(fid_str);
            sql.append("' AND FDATE = str_to_date('");
            sql.append(fdate_str);
            sql.append("', '%Y-%m-%d')");
            System.out.println(sql.toString());
            ResultSet rs = stmt.executeQuery(sql.toString());

            // get list
            ObservableList<Ticket> list = FXCollections.observableArrayList();

            //STEP 4: Extract data from result set
            insertData2Table(rs, list);

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                // nothing we can do
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fid.setCellValueFactory(new PropertyValueFactory<Ticket, String>("fid"));
        oplace.setCellValueFactory(new PropertyValueFactory<Ticket, String>("oplace"));
        tplace.setCellValueFactory(new PropertyValueFactory<Ticket, String>("tplace"));
        fdate.setCellValueFactory(new PropertyValueFactory<Ticket, String>("fdate"));
        otime.setCellValueFactory(new PropertyValueFactory<Ticket, String>("otime"));
        ttime.setCellValueFactory(new PropertyValueFactory<Ticket, String>("ttime"));
        remainder.setCellValueFactory(new PropertyValueFactory<Ticket, String>("remainder"));
        price.setCellValueFactory(new PropertyValueFactory<Ticket, String>("price"));
        dcnt.setCellValueFactory(new PropertyValueFactory<Ticket, String>("dcnt"));
        drate.setCellValueFactory(new PropertyValueFactory<Ticket, String>("drate"));
        comp.setCellValueFactory(new PropertyValueFactory<Ticket, String>("comp"));
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Conn.DB_URL, Conn.USER, Conn.PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // execute sql
            String sql;
            sql = "SELECT * FROM FLIGHT";
            ResultSet rs = stmt.executeQuery(sql);

            // define DateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // get list
            ObservableList<Ticket> list = FXCollections.observableArrayList();

            //STEP 4: Extract data from result set
            insertData2Table(rs, list);

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                // nothing we can do
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
