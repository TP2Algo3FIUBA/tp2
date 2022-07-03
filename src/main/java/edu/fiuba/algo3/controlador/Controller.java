//package edu.fiuba.algo3.controlador;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//
//public class Controller {
//
//    @FXML
//    private Rectangle myRectangle;
//    private double x;
//    private double y;
//
//    public void Norte(ActionEvent e) {
//        System.out.println("N");
//        myRectangle.setY(y-=10);
//    }
//    public void Sur(ActionEvent e) {
//        System.out.println("S");
//        myRectangle.setY(y+=10);
//    }
//    public void Este(ActionEvent e) {
//        System.out.println("E");
//        myRectangle.setX(x+=10);
//    }
//    public void Oeste(ActionEvent e) {
//        System.out.println("O");
//        myRectangle.setX(x-=10);
//    }
//}