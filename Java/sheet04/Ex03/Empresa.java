package Java.sheet04.Ex03;

public class Empresa {
    private String cif;
    private String name;

    public Empresa() {
    }

    public Empresa(String cif, String name) {
        this.cif = cif;
        this.name = name;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
