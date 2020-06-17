package com.javaex.phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String id = "phonedb";
    private String pw = "phonedb";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int count;

    public void phoneDao() {
    }

    private void getConnect() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, pw);
        } catch (ClassNotFoundException e) {
            System.out.println("error: 드라이버 로딩 실패 - " + e);
        } catch (SQLException e) {
            System.out.println("error:" + e);
        }
    }

    private void closeConnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("error:" + e);
        }
    }

    public List<PersonVo> getPersonList() {
        getConnect();
        List<PersonVo> personList = new ArrayList<PersonVo>();

        try {
            String personSelectQuery =
                    "select  person_id," +
                            "        name," +
                            "        hp," +
                            "        company " +
                            "from    person";
            pstmt = conn.prepareStatement(personSelectQuery);
            rs = pstmt.executeQuery();
            // 4.결과처리
            while (rs.next()) {
                int personId = rs.getInt("person_id");
                String name = rs.getString("name");
                String hp = rs.getString("hp");
                String company = rs.getString("company");

                PersonVo personVo = new PersonVo(personId, name, hp, company);
                personList.add(personVo);
            }

        } catch (SQLException e) {
            System.out.println("error:" + e);
        }

        closeConnect();

        return personList;
    }

    public int personInsert(PersonVo personVo) {
        getConnect();

        try {
            String personInserQuery =
                    "insert into person " +
                            "values(seq_person_id.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(personInserQuery);
            pstmt.setString(1, personVo.getName());
            pstmt.setString(2, personVo.getHp());
            pstmt.setString(3, personVo.getCompany());

            count = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error:" + e);
        }

        closeConnect();

        return count;
    }

    public int personUpdate(PersonVo personVo) {
        getConnect();

        try {
            String personUpdateQuery =
                    "update person " +
                            "set name = ?, " +
                            "    hp = ?,  " +
                            "    company = ? " +
                            "where person_id = ?  ";
            pstmt = conn.prepareStatement(personUpdateQuery);
            pstmt.setString(1, personVo.getName());
            pstmt.setString(2, personVo.getHp());
            pstmt.setString(3, personVo.getCompany());
            pstmt.setInt(4, personVo.getPersonId());

            count = pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("error:" + e);
        }

        closeConnect();

        return count;
    }

    public int personDelete(int personId) {
        getConnect();

        try {
            String personDeleteQuery =
                    "delete person " +
                            "where person_id = ? ";
            pstmt = conn.prepareStatement(personDeleteQuery);
            pstmt.setInt(1, personId);
            count = pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("error:" + e);
        }

        closeConnect();

        return count;
    }
}
