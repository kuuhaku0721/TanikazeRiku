package com.tanikazeriku.controller.Test;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

/**
 * 各种各样的测试用的
 */
@Slf4j
public class TestController {
    private String db_url = "jdbc:mysql://localhost:3306/kuudb?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true";
    private String db_username = "kuuhaku";
    private String db_pasword = "002016";
    private String imgPath = "C:\\Users\\Accel\\Desktop\\Learning Daily\\Kakuya_all\\Kakuya_event";

    public void writeToDB() {
      log.info("在这个函数中往数据库写图片");
      readIMGFromFolder();
    }

    private void readIMGFromFolder() {
        File folder = new File(imgPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
            if (files != null) {
                for (File file : files) {
                    try {
                        writeIMGToDatabase(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void writeIMGToDatabase(File img) throws SQLException, IOException {
        String imageName = img.getName().replaceFirst("[.][^.]+$", "");

        try (Connection connection = DriverManager.getConnection(db_url, db_username, db_pasword)) {
            String sql_characters = "UPDATE kakuya_characters SET image = ? WHERE name = ?";
            String sql_dungeon = "UPDATE kakuya_dungeon SET level_star = ? WHERE level = 3";
            String sql_event_easy = "UPDATE kakuya_event_easy SET image = ? WHERE type = ?";
            String sql_event_normal = "UPDATE kakuya_event_normal SET image = ? WHERE type = ?";
            String sql_event_difficult = "UPDATE kakuya_event_difficult SET image = ? WHERE type = ?";
            String sql_item = "UPDATE kakuya_item SET image = ? WHERE name = ?";
            String sql_users = "UPDATE kakuya_users SET icon = ? WHERE id = 1";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql_event_difficult)) {
                try (FileInputStream fis = new FileInputStream(img)) {
                    byte[] imageData = fis.readAllBytes();
                    preparedStatement.setBytes(1, imageData);
                    preparedStatement.setString(2, imageName);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("成功将图片 " + imageName + ".png 写入数据库。");
                    } else {
                        System.out.println("未找到名称为 " + imageName + " 的记录，无法写入图片。");
                    }
                }
            }
        }
    }

    /*
    使用的时候，controller用的是serviceImplement，implement实现了service接口，在implement中调用的mapper去获取数据库数据，mapper一一对应到mapper.xml真正执行数据库查询
     */

//    public CharacterCard getCharacterbyId(int id) {
//        CharacterCard characterCard = null;
//        try (Connection connection = DriverManager.getConnection(db_url, db_username, db_pasword)) {
//            String sql = "SELECT * FROM kakuya_characters WHERE id = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setInt(1, id);
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    if (resultSet.next()) {
//                        characterCard = new CharacterCard();
//                        characterCard.id = resultSet.getInt("id");
//                        characterCard.name = resultSet.getString("name");
//                        characterCard.image = resultSet.getBytes("image");
//                        characterCard.hp = resultSet.getInt("hp");
//                        characterCard.mp = resultSet.getInt("mp");
//                        characterCard.skill_id = resultSet.getInt("skill_id");
//                        characterCard.destroy = resultSet.getInt("destroy");
//                        characterCard.growth = resultSet.getInt("growth");
//                        characterCard.precision = resultSet.getInt("precision");
//                        characterCard.sustain = resultSet.getInt("sustain");
//                        characterCard.distance = resultSet.getInt("distance");
//                        characterCard.speed = resultSet.getInt("speed");
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return characterCard;
//    }

}
