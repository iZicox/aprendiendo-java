package com.scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        System.out.println("scraping web");

        // url a hacer scraping
        String url = "https://books.toscrape.com/";

        try {
            // obtener el dom
            Document dom = Jsoup.connect(url).get();

            // seleccionar varios elementos
            Elements nodosTitulos = dom.select(".product_pod > h3 > a");

            // imprimir los textos de los nodos
            for (Element ele : nodosTitulos) {
                System.out.println(ele.attr("title"));
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}