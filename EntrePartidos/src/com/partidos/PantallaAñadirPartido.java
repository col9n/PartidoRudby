package com.partidos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.logica.Logica;
import com.models.Partido;

import java.util.Date;

public class PantallaAñadirPartido extends Stage {

    public PantallaAñadirPartido(){



        initModality(Modality.APPLICATION_MODAL.APPLICATION_MODAL);
        setTitle("Ver los partidos existentes");

        Label labelNombreEquipoL = new Label("Nombre del equipo local");
        TextField textFieldEquipoL = new TextField();

        Label label1labelNombreEquipoV = new Label("Nombre del equipo visitante");
        TextField textFieldEquipoV = new TextField();

        Label label1labelDivision = new Label("Division");
        Partido.division[] divisiones = Partido.division.values();
        ObservableList<Partido.division> listaDivisiones = FXCollections.observableArrayList(divisiones);
        ComboBox<Partido.division> comboBox  = new ComboBox(listaDivisiones);

        Label labelResultadoLocal = new Label("Puntos equipo localo");
        TextField textFieldResultadoLocal = new TextField();

        Label labelResultadoVisitante = new Label("Puntos equipo visitante");
        TextField textFieldResultadoVisitante = new TextField();



        Label label1labelFecha = new Label("Fecha");
        DatePicker datePicker = new DatePicker();

        HBox HboxLocal = new HBox(labelNombreEquipoL);
        HBox HboxVisistante = new HBox(labelNombreEquipoL);
        HBox HboxDivision = new HBox(labelNombreEquipoL);
        HBox HboxResultadoLocal = new HBox(labelNombreEquipoL);
        HBox HboxResultadoVisitante = new HBox(labelNombreEquipoL);
        HBox HboxFecha = new HBox(labelNombreEquipoL);



        Button buttonGuardarPartido = new Button("Guardar el partido");
        Label labelVerPartido = new Label("Guardar el partido");
        buttonGuardarPartido.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String OjNombreEquipoL = textFieldEquipoL.getText();
                String OjNnombreEquipoV = textFieldEquipoV.getText();
                Partido.division ObjDivision = comboBox.getSelectionModel().getSelectedItem();
                Date ObjFecha =null;
                String ObjresultadoLocal = textFieldResultadoLocal.getText();
                String ObjresultadoVisitante = textFieldResultadoVisitante.getText();


                Partido par= new Partido(OjNombreEquipoL,OjNnombreEquipoV,ObjDivision,ObjFecha,ObjresultadoLocal,ObjresultadoVisitante);

                Logica.getInstance().añadirALista(par);

            }
        });

        SplitPane splitPaneLabel = new SplitPane(labelResultadoLocal,labelResultadoVisitante);
        SplitPane splitPaneText = new SplitPane(textFieldResultadoLocal,textFieldResultadoVisitante);
        VBox vboxPrincipal = new VBox(  labelNombreEquipoL,textFieldEquipoL,label1labelNombreEquipoV,textFieldEquipoV,
                label1labelDivision,comboBox,splitPaneLabel,splitPaneText,
                label1labelFecha,datePicker,buttonGuardarPartido);



        Scene scene = new Scene(vboxPrincipal,350,300);
        setScene(scene);
        show();


    }
}
