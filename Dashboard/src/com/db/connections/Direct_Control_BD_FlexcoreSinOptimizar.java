package com.db.connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * @author Monicaticooo
 */
public class Direct_Control_BD_FlexcoreSinOptimizar {

    private final Connection conection;
    private final Statement statement;
    public Object[][] infoFact;
    private static Direct_Control_BD_FlexcoreSinOptimizar AdminBD;

    public Direct_Control_BD_FlexcoreSinOptimizar(Connection conection, Statement statement) {
        this.conection = conection;
        this.statement = statement;

    }

    public static Direct_Control_BD_FlexcoreSinOptimizar getInstance() {
        if (AdminBD == null) {
            Setting_Up_BD_flexcoreSinOptimizar setting = new Setting_Up_BD_flexcoreSinOptimizar();
            AdminBD = new Direct_Control_BD_FlexcoreSinOptimizar(setting.getConection(), setting.getStatement());
        }
        return AdminBD;
    }

     public void valorInventario(String UbicacionInv) {// esta bien
       /** try {

            String valorInventario = this.readSql("/sql_files/ValorInventario.sql");
            PreparedStatement stm = this.conection.prepareStatement(valorInventario);
            stm.setString(1, UbicacionInv);
            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido del valor del inventario
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3)
                        + "||" + resultset.getInt(4) + "||"
                        + resultset.getInt(5));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener el valor del inventario");
        }**/

    }
     
     public void flush() throws SQLException{
         String query = "FLUSH STATUS;";
         statement.executeQuery(query);
     }
     
     public int getCommits() throws SQLException {
         int commits = 0;
         String query = "SHOW SESSION STATUS like 'Com_commit';";
         ResultSet rs = statement.executeQuery(query);
         while(rs.next()){
             commits = rs.getInt("Value");
         }
         return commits;
     }
    
    private String readSql(String filePath) throws IOException {
        InputStream inputfile = Direct_Control_BD_FlexcoreSinOptimizar.class.getClass().getResourceAsStream(filePath);
        StringBuilder sb;
        try (BufferedReader input = new BufferedReader(new InputStreamReader(inputfile))) {
            String str;
            sb = new StringBuilder();
            while ((str = input.readLine()) != null) {
                sb.append(str).append("\n");
            }
        }
        return sb.toString();
    }
}
