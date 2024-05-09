public class Alumnes {

    private Integer id_alumne;
    private String cognoms;
    private String nom;
    private String email;
    private String curs;

    public Alumnes (Integer id_alumne, String cognoms, String nom, String email, String curs) {
        this.id_alumne = id_alumne;
        this.cognoms = cognoms;
        this.nom = nom;
        this.email = email;
        this.curs = curs;
    }
    

    //Geters i seters
    /**
     * @return Integer return the id_alumne
     */
    public Integer getId_alumne() {
        return id_alumne;
    }

    /**
     * @param id_alumne the id_alumne to set
     */
    public void setId_alumne(Integer id_alumne) {
        this.id_alumne = id_alumne;
    }

    /**
     * @return String return the cognoms
     */
    public String getCognoms() {
        return cognoms;
    }

    /**
     * @param cognoms the cognoms to set
     */
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the curs
     */
    public String getCurs() {
        return curs;
    }

    /**
     * @param curs the curs to set
     */
    public void setCurs(String curs) {
        this.curs = curs;
    }

}
