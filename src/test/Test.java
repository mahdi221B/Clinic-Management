package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import entites.Categorie;
import entites.Sponsor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import services.EvenementService;
import services.SponsorService;
import outils.TypeSponsoring;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import services.CategorieService;


/**
 *
 * @author mahdi
 */
public class Test {
    public static void main(String[] args) throws ProtocolException, MalformedURLException, IOException, ParseException {
       //EvenementService es = new EvenementService();
       //SponsorService ss = new SponsorService();
       //TypeEvenementService ess = new TypeEvenementService();
       //SponsorService es = new SponsorService();
       
       //es.getAll();
        //TypeSponsoring ts = TypeSponsoring.A;
        //Date date = new Date();
        //SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        //System.out.println(DateFor.format(date));
        //Sponsor s = new Sponsor(444333,444333,"GGG","GGG",ts.toString());
        //ss.ModifierSponsor(s);
       // ss.SupprimerSponsor(s);
       //*************************************************************************************************************
       //Evenement e = new Evenement(78497,2389,"aaa", "bbb", "lkznz", "lkdzl", "kznezek", DateFor.format(date), DateFor.format(date));
       //Evenement e = new Evenement(1,1234,33300,"hjk", "dokz", "lkznz", "lkdzl", "kznezek", DateFor.format(date), DateFor.format(date));
      // Evenement e = new Evenement(1);
       //es.AjouterEvenement(e);
       //es.ModifierEvenement(e);
       //es.SupprimerEvenement(e);
       
       //**************************************************************************************************************
      //TypeEvenement e = new TypeEvenement("Type1");
       //TypeEvenement e = new TypeEvenement(1,"Type2");
      // TypeEvenement e = new TypeEvenement(1);
       //ess.AjouterTypeEvenement(e);
       //ess.ModifierTypeEvenement(e);
       //ess.SupprimerTypeEvenement(e);
       //System.out.println(ess.getAllTypeEvenement());
      // System.out.println(es.getAll());
      
       
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      /*URL url = new URL("https://www.metaweather.com/api/location/search/?query=London");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);


                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                //Get the first JSON object in the JSON array
                System.out.println(dataObject.get(0));

                JSONObject countryData = (JSONObject) dataObject.get(0);

                System.out.println(countryData.get("woeid"));

            }*/
      
      
      
      
      
      /*
              ArrayList<String> names = new ArrayList<String>();
              ArrayList<Double> salaries = new ArrayList<Double>();

              while(rst.next()) 
              {
              names.add(rst.getString(1));
              salaries.add(rst.getDouble(2));
              }
              CategoryAxis xAxis = new CategoryAxis();
              xAxis.setLabel("Names") ;
              NumberAxis yAxis = new NumberAxis();
              yAxis.setLabel("Salaries");

              BarChart barChart = new BarChart(xAxis, yAxis);
              XYChart.Series dataSeries1 = new XYChart.Series();
              dataSeries1.setName("Employees Table");

              for (int i = 0; i < names.size(); i++) {
              dataSeries1.getData().add(new XYChart.Data(names.get(i), salaries.get(i)));

              }
              barChart.getData().add(dataSeries1) ;

              VBox vbox = new VBox(barChart);*/
    }
}
