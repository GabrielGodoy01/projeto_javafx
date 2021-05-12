package br.maua.Controller;

import br.maua.DAO.PokCartaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class Controller {
    private PokCartaDAO pokCartaDAO;

    @FXML
    private TextField txtNome, txtId, txtRaridade, txtSerie, txtColecao, txtUrl;

    @FXML
    public void cadastrar(){
        pokCartaDAO.getInsertString("cartas", txtId, txtNome, txtRaridade, txtSerie, txtColecao, txtUrl);
    }

    @FXML
    public void print(){
        pokCartaDAO.getAll();
    }
}
