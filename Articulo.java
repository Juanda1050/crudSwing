package crud;

public class Articulo
{
    public int cve_art;
    public String nom_art;
    public int cat_art;
    public int prov_art;
    public float pre_art;
    public int inv_art;

    public Articulo(int cve_art, String nom_art, int cat_art, int prov_art, float pre_art, int inv_art) {
        this.cve_art = cve_art;
        this.nom_art = nom_art;
        this.cat_art = cat_art;
        this.prov_art = prov_art;
        this.pre_art = pre_art;
        this.inv_art = inv_art;
    }
}