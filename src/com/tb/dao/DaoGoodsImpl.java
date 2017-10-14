package com.tb.dao;


import com.tb.bean.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoGoodsImpl {
    public static ArrayList<Goods> selectAllGoods() throws SQLException {
        Connection conn = Dao.getConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM t_goods";
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Goods> goodsList = new ArrayList<>();
        while (rs.next()) {
            int goodsId = rs.getInt("good_id");
            String goodsName = rs.getString("name");
            String goodsType = rs.getString("type");
            String useWat = rs.getString("useWay");
            int stock = rs.getInt("stock");
            float price = rs.getFloat("price");
            String pic = rs.getString("pic");
            Goods goods = new Goods(goodsId, goodsName, goodsType, useWat, price, pic, stock);
            goodsList.add(goods);
        }
        Dao.closeAll(rs, st, conn);
        return goodsList;
    }

    public static Goods getGoodsById(Object goodsNo) throws SQLException {
        Connection conn = Dao.getConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM t_goods WHERE goodId =" + goodsNo;
        ResultSet rs = st.executeQuery(sql);
        Goods goods = null;
        if (rs.next()) {
            int goodsId = rs.getInt("goodId");
            String goodsName = rs.getString("name");
            String goodsType = rs.getString("type");
            String useWat = rs.getString("useWay");
            int stock = rs.getInt("stock");
            float price = rs.getFloat("price");
            String pic = rs.getString("pic");
            goods = new Goods(goodsId, goodsName, goodsType, useWat, price, pic, stock);
        }
        return goods;
    }

    public static boolean updateGoodsNum(int goodsNo, int addNum) throws SQLException {
        Connection conn = Dao.getConnection();
        Statement st = conn.createStatement();
        String sql = "UPDATE t_goods SET stock=stock+'" + addNum + "' WHERE goodId='" + goodsNo + "';";
        return st.executeUpdate(sql) > 0;
    }

    public static boolean insertGoods(Goods goods) throws SQLException {
        Connection conn = Dao.getConnection();
        Statement st = conn.createStatement();
        String sql = "INSERT INTO t_goods (goodId,type,useWay,stock,price,pic) VALUES ('%s','%s','%s','%s','%s','%s');";
        sql = String.format(sql, goods.getName(), goods.getType(), goods.getUseWay(), goods.getStock(), goods.getPrice(), goods.getPic());
        return st.executeUpdate(sql) > 0;
    }

    public static boolean updateGoods(Goods goods) throws SQLException {
        Connection conn = Dao.getConnection();
        Statement st = conn.createStatement();
        String sql = "UPDATE t_goods SET name='%s',type='%s',useWay='%s',stock='%s',price='%s',pic='%s' WHERE goodId='%s';";
        sql = String.format(sql, goods.getName(), goods.getType(), goods.getUseWay(), goods.getStock(), goods.getPrice(), goods.getPic(), goods.getId());
        return st.executeUpdate(sql) > 0;
    }

    public static boolean deleteGoodsById(int deleteGoodsNo) throws SQLException {
        Connection conn = Dao.getConnection();
        Statement st = conn.createStatement();
        String sql = "DELETE FROM t_goods WHERE goodId='%d'";
        sql = String.format(sql, deleteGoodsNo);
        return st.executeUpdate(sql) > 0;
    }
}
