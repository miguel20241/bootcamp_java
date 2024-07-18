package Java.sheet04.Ex02;

import java.util.Objects;

public class Ordenadores {
    private String marca;
    private String modelo;
    private int ram;
    private int discoDuro = 50;
    private int discoDuroUtilizado;
    private boolean encendido = false;

    public Ordenadores() {
    }

    public Ordenadores(int ram) {
        this.ram = ram;
    }

    public Ordenadores(int ram, int discoDuro) {
        this.ram = ram;
        this.discoDuro = discoDuro;
    }

    public Ordenadores(String marca, String modelo, int discoDuro, int ram) {
        this.marca = marca;
        this.modelo = modelo;
        this.discoDuro = discoDuro;
        this.ram = ram;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) throws Exception {
        if (esPotenciaDeDos(ram)) {
            this.ram = ram;
        } else {
            throw new Exception("La RAM debe ser potencia de 2");
        }
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    public int getDiscoDuroUtilizado() {
        return discoDuroUtilizado;
    }

    public void setDiscoDuroUtilizado(int discoDuroUtilizado) {
        this.discoDuroUtilizado = discoDuroUtilizado;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    @Override
    public String toString() {
        return "Ordenadores{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ram=" + ram +
                ", discoDuro=" + discoDuro +
                ", discoDuroUtilizado=" + discoDuroUtilizado +
                ", encendido=" + encendido +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordenadores that = (Ordenadores) o;
        return Objects.equals(getMarca(), that.getMarca()) && Objects.equals(getModelo(), that.getModelo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMarca(), getModelo());
    }

    public static boolean esPotenciaDeDos(int numero) {
        if (numero <= 0) {
            return false;
        }

        for (int i = numero; i > 1; i /= 2) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public void encender() {
        setEncendido(true);
    }

    public void apagar() {
        setEncendido(false);
    }

    public void transferirArchivos(int datosGB) {
        if (isEncendido()) {
            if (getDiscoDuro() - getDiscoDuroUtilizado() - datosGB >= 0) {
                setDiscoDuroUtilizado(getDiscoDuroUtilizado() + datosGB);
            } else {
                System.out.println("No hay espacio suficiente.");
            }
        } else {
            System.out.println("El ordenador está apagado.");
        }
    }

    public void eliminarArchivos(int datosGB) {
        if (isEncendido()) {
            if (getDiscoDuro() - datosGB < 0) {
                setDiscoDuroUtilizado(0);
            } else {
                setDiscoDuroUtilizado(getDiscoDuroUtilizado() + datosGB);
            }
        } else {
            System.out.println("El ordenador está apagado.");
        }
    }
}
