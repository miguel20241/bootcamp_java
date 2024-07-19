package Java.sheet04.Ex02;

public class Main {
    public static void main(String[] args) throws Exception {
        Ordenadores ordenador1 = new Ordenadores("Dell", "EliteBook", 500, 16);
        System.out.println(ordenador1.toString());

        Ordenadores ordenador2 = new Ordenadores();
        ordenador2.setMarca("Dell2");
        ordenador2.setModelo("EliteBook2");
        ordenador2.setRam(16);

        Ordenadores ordenador4 = new Ordenadores(32);
        System.out.println("Ordenador4 es igual a Ordenador3: " + ordenador4.equals(ordenador2));

        System.out.println("hasCode: " + ordenador1.hashCode());

        System.out.println(ordenador1);
        ordenador1.encender();
        System.out.println("Encendido: " + ordenador1.isEncendido());

        ordenador1.transferirArchivos(200);
        System.out.println("Transfiriendo 200GB: " + ordenador1.getDiscoDuroUtilizado());
        ordenador1.transferirArchivos(400);
        System.out.println("Transfiriendo 400GB: " + ordenador1.getDiscoDuroUtilizado());
        ordenador1.eliminarArchivos(100);
        System.out.println("Eliminando 100GB: " + ordenador1.getDiscoDuroUtilizado());
        ordenador1.eliminarArchivos(200);
        System.out.println("Eliminando 200GB: " + ordenador1.getDiscoDuroUtilizado());

        ordenador1.apagar();
        System.out.println("Apagado: " + ordenador1.isEncendido());

        Ordenadores ordenador3 = new Ordenadores(8, 500);
        ordenador3.setRam(33);
    }
}
