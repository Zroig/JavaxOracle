/*
 * Tutorial fet per Mateo Cerna (@Zroig on Github) dedicat a ensenyar les bases de com fer servir jdbc
 * per unir Oracle amb Java. Abans de poder fer funcionar aquest arxiu necessitareu instal·lar la llibreria
 * de jdbc per a la vostre versió de jdk al projecte.
 */

import java.sql.*; //Importem les llibreries de sql

public class Tutorial {
    public static void main(String[] args) {
        //dins de un try catch fem el codi, això es deu a que la connexió pot fallar i el programa ha d'estar preparat
        try {

            //Afegim aquesta linia per inicialitzar el driver:
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Creem una connexió a la base de dades, cal que creu l'usuari i contrasenya abans i l'hi creeu la taula
            Connection conexio = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/FreePDB1", "nomUsuari", "contrasenya");
            //Després del '@' posem l'enllaç a la nostre BDD

            //Ara el que farem serà un codi que faci un select de tota la taula i la imprimeixi:

            //Creem un PreparedStatement que és una linia de codi sql que deixem preparada per executar:
            PreparedStatement selectAll = conexio.prepareStatement("select * from TAULA");

            /*
             * Ara podem fer coses com selectAll.executeQuery() per executar, la cosa es que això retornara unes dades en
             * format ResultSet, llavors desarem el resultat a un ResultSet
             */

            ResultSet resultat = selectAll.executeQuery();

            /*
             * Llavors ara per imprimir les dades, per fer-ho farem un bucle que funcionarà com un cursor sql per 
             * iterar totes les files de la taula
             */

            while (resultat.next()) {
                /*
                 * Per fer això farem servir la funció .getInt o .getString per obtindre la informació, el numero que demana
                 * la funció és el número de la columna (començant a 1) que voleu del resultat, també podeu posar en format string el nom de
                 * la columna ("nomColumna")
                 */
                
                System.out.println(resultat.getInt(1)+" "+resultat.getString(2)+" "+
                    resultat.getInt("edat")+" "+resultat.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
