package kim.nikita.controller;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        Map<String, Integer> heroes = getHeroesFromDb();
        try {
            Document document2 = Jsoup.connect("https://www.dotabuff.com/matches?game_mode=all_pick").get();
            Element table = document2.select("table").first();
            Element tableBody = table.select("tbody").first();
            Elements rows = tableBody.select("tr");
            for (Element row : rows) {
                String string = new String();
                string = ".addData(new double[]{";
                Element element = row.select("a").first();
                String matchResult = row.select("td").get(2).select("a").first().text();

                int result = 0;
                if (matchResult.equals("Radiant Victory"))
                    result = 1;
                else
                    result = -1;
                Elements radiantHeroes = row.select("td").get(4).select("div");

                for (Element heroElement : radiantHeroes) {
                    String radiantHero = heroElement.select("a").attr("href");
                    if (radiantHero.length() > 0)
                        string += heroes.get(radiantHero.substring(8)) + ", ";
                }

                Elements direHeroes = row.select("td").get(5).select("div");

                for (Element heroElement : direHeroes) {
                    String direHero = heroElement.select("a").attr("href");
                    if (direHero.length() > 0)
                        string += heroes.get(direHero.substring(8)) + ", ";
                }
                string = string.substring(0, string.length() - 2);
                string += "}, new double[]{";
                string += result + "})";
                list.add(string);
                String match = element.attr("href");
                match = match.substring(9);
                try {
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO matches (id_in_dotabuff,string) values (?,?)");
                    statement.setObject(1, match);
                    statement.setObject(2, string);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(list);

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM matches");
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> getHeroesFromDb() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        Map<String, Integer> result = new HashMap<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM HEROES");
            while (rs.next()) {
                result.put(rs.getString(2), Integer.parseInt(rs.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
