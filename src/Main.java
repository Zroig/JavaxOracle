import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("localhost:1521/FreePDB1", "mcernaMP3", "hola")) {
            
            System.out.println("Que vols fer?\n 1. Imprimir tota la taula\n 2. Obtindre l'alumne que es diu Marc\n 3. Afegir un alumne\n 4. Imprimir tots els cognoms");
            Scanner sc = new Scanner(System.in);
            int opcio;
            while (true) {

                opcio = sc.nextInt();

                if (opcio > 0 || opcio<4) {
                    break;
                }
            }
            
            switch (opcio) {
                case 1:
                    //Imprimir taula
                    PreparedStatement selectAll = conn.prepareStatement("select * from alumnes");
                    ResultSet resultatQuery = selectAll.executeQuery();
                    List<Alumnes> alumnes = new ArrayList<>();

                    while (resultatQuery.next()) {
                        Integer id_alumne = resultatQuery.getInt(0);
                        String cognoms = resultatQuery.getString(1);
                        String nom = resultatQuery.getString(2);
                        String email = resultatQuery.getString(3);
                        String curs = resultatQuery.getString(4);

                        Alumnes alumne = new Alumnes(id_alumne, cognoms, nom, email, curs);
                        alumnes.add(alumne);
                    }

                    System.out.println(alumnes);

                    break;
                case 2:
                    //Obtindre l'alumne que es diu Marc
                    PreparedStatement selectNom = conn.prepareStatement("select nom from alumnes where nom like 'Marc'");
                    ResultSet resultatNom = selectNom.executeQuery();
                    System.out.println(resultatNom.getString(2));
                    break;
                case 3:
                    //Afegir un alumne
                    Integer id_alumne = sc.nextInt();
                    String cognoms = sc.next();
                    String nom = sc.next();
                    String email = sc.next();
                    String curs = sc.next();

                    PreparedStatement insertAlumne = conn.prepareStatement("insert into alumnes (id_alumne, cognoms, nom, email, curs) values ("+id_alumne+","+cognoms+","+nom+","+email+","+curs);
                    insertAlumne.executeQuery();
                    break;
                case 4:
                    //Imprimir tots els cognoms
                    PreparedStatement selectCognoms = conn.prepareStatement("select cognoms from alumnes");
                    ResultSet resultatCognoms = selectCognoms.executeQuery();
                    ArrayList<String> cognomsArr = new ArrayList<>();
                    while (resultatCognoms.next()) {
                        cognomsArr.add(resultatCognoms.getString(0));
                    }
                    break;
            }
            
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
