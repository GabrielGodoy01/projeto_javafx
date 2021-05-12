package br.maua.DAO;

import javafx.scene.control.TextField;

public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getUpdateString(String table);
    String getInsertString(String table, TextField txtId, TextField txtNome, TextField txtRaridade, TextField txtSerie, TextField txtColecao, TextField txtUrl);
    String getSelectAllString(String table);
    String getSelectConditionalString(String table);
}
