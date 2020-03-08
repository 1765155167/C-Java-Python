import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Main {
    // JDBC连接的URL, 不同数据库有不同的格式:
    static final String JDBC_URL = "jdbc:mysql://127.0.0.1/learnJdbc?useSSL=false&characterEncoding=utf8&allowPublicKeyRetrieval=true";
    static final String JDBC_USER = "hqf";
    static final String JDBC_PASSWORD = "hqf666123";

    HikariConfig config;
    DataSource ds;

    public Main() {
        config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(JDBC_USER);
        config.setPassword(JDBC_PASSWORD);
        config.addDataSourceProperty("connectionTimeout","1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout","60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize","10"); // 最大连接数：10
        ds = new HikariDataSource(config);
    }

    public static void main(String[] args) {
        Main main = new Main();
        // 获取连接:
        //确保Connection Statement ResultSet 及时关闭
        try (Connection conn = main.ds.getConnection()) {
            //查询
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT id, grade, name, gender FROM students WHERE gender=?")) {
                ps.setObject(1, 2); // 注意：索引从1开始
                try (ResultSet rs = ps.executeQuery()) {
                    System.out.println("id    |grade |name  |gender|");
                    while (rs.next()) {//用于判断是否有下一行记录
                        long id = rs.getLong("id"); // 注意：索引从1开始而不是0
                        long grade = rs.getLong("grade");
                        String name = rs.getString("name");
                        String gender = rs.getString("gender");
                        System.out.println(id +
                                "    |" + grade +
                                " |" + name +
                                "  |" + gender);
                    }
                }
            }
            //插入
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO students (grade, name, gender, score) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, 4);
                ps.setObject(2, "小胡");
                ps.setObject(3, 0);
                ps.setObject(4, 99);
                int n = ps.executeUpdate();
                try (ResultSet r = ps.getGeneratedKeys()) {
                    if (r.next()) {
                        long id = r.getLong(1);
                        System.out.println("插入的id = " + id);
                    }
                }
            }
            //更新
            try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
                ps.setObject(1, "Bob"); // 注意：索引从1开始
                ps.setObject(2, 17);
                int n = ps.executeUpdate(); // 返回更新的行数
                System.out.println("更新的行数 = " + n);
            }
//            //删除
//            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
//                ps.setObject(1, 19); // 注意：索引从1开始
//                int n = ps.executeUpdate(); // 删除的行数
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
