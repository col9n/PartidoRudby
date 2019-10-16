package com.partidos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.logica.Logica;
import com.models.Partido;

public class PantallaVerPartido extends Stage{

    TableView tableView;
  public PantallaVerPartido(){



       initModality(Modality.APPLICATION_MODAL.APPLICATION_MODAL);
       setTitle("Ver los partidos existentes");





        TableView tableView = new TableView(Logica.getInstance().obternerListaPartido());
        TableColumn<String, Partido> column1 = new TableColumn<>("Nombre local");
        column1.setCellValueFactory(new PropertyValueFactory<>("local"));

        TableColumn<String, Partido> column2 = new TableColumn<>("nombre visitante");
        column2.setCellValueFactory(new PropertyValueFactory<>("visitante"));

        TableColumn<String, Partido> column3 = new TableColumn<>("Division");
        column3.setCellValueFactory(new PropertyValueFactory<>("div"));

        TableColumn<String, Partido> column4 = new TableColumn<>("Puntos local");
        column4.setCellValueFactory(new PropertyValueFactory<>("resultadoLocal"));

        TableColumn<String, Partido> column5 = new TableColumn<>("Punto visitante");
        column5.setCellValueFactory(new PropertyValueFactory<>("resultadoVisitante"));

          TableColumn<String, Partido> column6 = new TableColumn<>("Fecha");
          column6.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);

      Button borrar = new Button(" Borrar ");
      borrar.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent event) {
              if(Logica.getInstance().obternerListaPartido().size()>0) {
                  Logica.getInstance().obternerListaPartido().remove(tableView.getSelectionModel()
                          .getSelectedIndex());
              }
          }
      });

      Button Modificar = new Button(" Modificar ");
      borrar.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent event) {

            System.out.println(Logica.getInstance().obternerListaPartido().get(tableView.getSelectionModel()
                      .getSelectedIndex()).toString());

          }
      });





      HBox HboxBoton = new HBox(borrar);
      HBox HboxBoton1 = new HBox(Modificar);
      VBox Vboxtoal= new VBox(tableView,HboxBoton,HboxBoton1);
      Scene scene = new Scene(Vboxtoal,600,600);
      setScene(scene);
      show();


    }


}
