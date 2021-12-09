package kim.nikita.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("https://www.dotabuff.com/matches/6312062934").get();
            Elements tables = doc.select("table");
            Element tableRadiant = tables.get(0);
            Elements elementsRadiant = tableRadiant.select("tbody > tr > td > div > a");
            elementsRadiant.stream().map(e -> e.attr("href")).filter(a->a.startsWith("/heroes/")).map(h->h.substring(8)).forEach(System.out::println);
            System.out.println();
            Element tableDire=tables.get(1);
            Elements elementsDire = tableDire.select("tbody > tr > td > div > a");
            elementsDire.stream().map(e -> e.attr("href")).filter(a->a.startsWith("/heroes/")).map(h->h.substring(8)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
