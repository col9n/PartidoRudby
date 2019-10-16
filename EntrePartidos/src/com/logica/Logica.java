package com.logica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.models.Partido;

public class Logica {
    private static Logica INSTACE=null;
    ObservableList<Partido> listaPartido;
    private Logica(){
        listaPartido= FXCollections.observableArrayList();


    }

    public static Logica getInstance(){
        if (INSTACE==null)
            INSTACE=new Logica();
        return INSTACE;
    }




    public ObservableList obternerListaPartido(){

        return listaPartido;
    }

    public void añadirALista(Partido par){
        listaPartido.add(par);

    }

    public void quitarPartido(Partido par){

        listaPartido.remove(par);
    }

    public void monstrarListaPartido(){
        for(Partido par:listaPartido)
        {
            System.out.println(par.toString());
        }
    }
}
