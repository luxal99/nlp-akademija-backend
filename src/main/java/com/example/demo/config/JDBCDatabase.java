package com.example.demo.config;

import com.example.demo.entity.OnlinePurchase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBCDatabase {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://35.246.218.201 :3306";
    private static String username = "luxal";
    private static String password = "Lukic.aleksa99";
    private static String databaseName = "nlp_akademija_dev";

    public static void openConection() throws SQLException {
        connection = DriverManager.getConnection(url + "/" + databaseName, username, password);
    }

    public static String inserPurchase(List<OnlinePurchase> onlinePurchaseList) {
    for (int i =0;i<onlinePurchaseList.size();i++){
        System.out.println(onlinePurchaseList.get(i).getIdProduct().toString());
    }
        try {
            openConection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into nlp_akademija_dev.online_purchase(id_client, id_product, comment, social_link, country) values (?,?,?,?,?)");
            for (int i = 0; i < onlinePurchaseList.size(); i++) {
                preparedStatement.setLong(1, onlinePurchaseList.get(i).getIdClient().getIdClient());
                preparedStatement.setLong(2, onlinePurchaseList.get(i).getIdProduct().getIdProduct());
                preparedStatement.setString(3, onlinePurchaseList.get(i).getComment());
                preparedStatement.setString(4, onlinePurchaseList.get(i).getCountry());
                preparedStatement.setString(5, onlinePurchaseList.get(i).getSocialLink());

                preparedStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Uspesno sacuvan";
    }

}