package Java.sheet04.Ex01;

public class Main {
    public static void main(String[] args) {
        Biblioteca libro1 = new Biblioteca(
                "234243kjk23424",
                "El libro gordo de Petete",
                456,
                "Petete",
                false);

        System.out.println(libro1);

        System.out.println(libro1.prestar());

        libro1.devolver();
        System.out.println("El libro está prestado?: " + libro1.isPrestado());

        System.out.println(libro1.imprimir(0.34));

        Biblioteca libro2 = new Biblioteca();

        libro2.setISBN("329874398534");
        libro2.setTitulo("hola mundo");
        libro2.setAutor("yo");
        libro2.setNumeroPaginas(200);
        libro2.setPrestado(false);

        System.out.println(libro2);

        System.out.println(libro2.prestar());

        libro2.devolver();
        System.out.println("El libro está prestado?: " + libro2.isPrestado());

        System.out.println(libro2.imprimir(0.50));
    }
}
