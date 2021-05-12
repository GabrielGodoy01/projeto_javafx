package br.maua.DAO;

import br.maua.Model.PokCarta;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokCartaDAO implements DAOFields, DAO<PokCarta> {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:cartas.db";

    public PokCartaDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<PokCarta> get(String condition) {
        List<PokCarta> pokCartas = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                PokCarta pokCarta = new PokCarta(
                        result.getString("id"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao"),
                        result.getString("url")
                );
                pokCartas.add(pokCarta);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return pokCartas;
    }

    @Override
    public List<PokCarta> getAll() {
        List<PokCarta> pokCartas = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                PokCarta pokCarta = new PokCarta(
                        result.getString("id"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao"),
                        result.getString("url")
                );
                pokCartas.add(pokCarta);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return pokCartas;
    }

    @Override
    public void update(PokCarta pokCarta) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, pokCarta.getId());
            preparedStatement.setString(2, pokCarta.getNome());
            preparedStatement.setString(3, pokCarta.getRaridade());
            preparedStatement.setString(4, pokCarta.getSerie());
            preparedStatement.setString(5, pokCarta.getColecao());
            preparedStatement.setString(6, pokCarta.getUrl());
            preparedStatement.setString(7, pokCarta.getId());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PokCarta pokCarta) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, pokCarta.getId());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }




    @Override
    public String getTableName() {
        return "cartas";
    }

    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM " + table + " WHERE id = ?";
    }

    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET id = ?, nome = ?, raridade = ?, serie = ?, colecao = ?, url = ? WHERE id = ?;";
    }

    @Override
    public String getInsertString(String table, TextField txtId, TextField txtNome, TextField txtRaridade, TextField txtSerie, TextField txtColecao, TextField txtUrl) {
        return "INSERT INTO "+ table + " (id, nome, raridade, serie, colecao, url) VALUES ("+txtId+","+txtNome+","+txtRaridade+","+txtSerie+","+txtColecao+","+txtUrl+");";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
