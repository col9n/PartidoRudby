package com.partidos;

import com.models.Partido;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.logica.Logica;

import java.io.*;
import java.util.List;


public class Main extends Application {

    public void start(Stage stage) throws Exception{

        Logica.getInstance();
        stage.setTitle("App de partidos");
        VBox vBox = new VBox();

        HBox hbox1 = new HBox();
        hbox1.getChildren().add(new Label("¿Que deseas hacer?"));



        Button buttonAñadir = new Button("Añadir partido");
        Label labelAñadirPartido = new Label("");
        buttonAñadir.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage pantallaAñadirPartido= new PantallaAñadirPartido();
            }
        });

        Button buttonVer = new Button("Ver Partidos");
        Label labelVerPartido = new Label("");
        buttonVer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage pantallaVerPartido= new PantallaVerPartido();
            }
        });


        Button buttonGuardar = new Button("Guardar Partidos");
        Label labelguardarPartidos = new Label("");
        buttonGuardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                guardarDatosFichero();
            }
        });
        Button buttonLeer = new Button("leerPartidos");
        Label labelleerPartidos = new Label("");
        buttonLeer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                leerDelFichero();
            }
        });





        HBox hbox2 = new HBox();
        hbox2.getChildren().add(buttonAñadir);
        hbox2.getChildren().add(buttonVer);

        hbox2.getChildren().add(buttonGuardar);
        hbox2.getChildren().add(buttonLeer);



        hbox2.setSpacing(10);

        vBox.getChildren().add(hbox1);
        vBox.getChildren().add(hbox2);

        Scene scene = new Scene(vBox, 700, 700);
        stage.setScene(scene);
        stage.show();

    }

    public static void leerDelFichero() {


        FileInputStream fin  ;
        ObjectInputStream oin =null ;
        try {
            fin  = new FileInputStream("data.dat");
            oin  = new ObjectInputStream(fin );
            Object aux = oin.readObject();
            while (aux!=null)
            {

                Logica.getInstance().obternerListaPartido().add(aux);
                aux = oin.readObject();
            }



        }
        catch(EOFException e){
           // e.printStackTrace();
        }
        catch(IOException| ClassNotFoundException e ){
            e.printStackTrace();
        }finally{
            try{
                oin .close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }

    public static void guardarDatosFichero() {


        FileOutputStream Fout  = null;
        ObjectOutputStream oout  = null;
        try {
            Fout = new FileOutputStream("data.dat");
            oout  = new ObjectOutputStream(Fout );
            List<Partido> partidosLedios =(List<Partido>) Logica.getInstance().obternerListaPartido();
            for (Partido par:partidosLedios)
            {
                oout.writeObject(par);
            }


            oout .flush();



        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                    Fout .close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args){

        launch(args);


    }


}
