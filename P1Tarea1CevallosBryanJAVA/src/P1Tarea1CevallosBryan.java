
	import java.io.*;
	import java.util.Scanner;

	public class P1Tarea1CevallosBryan {
	    private static float notas1, notas2, notas3, result;
	    private static Scanner scanner = new Scanner(System.in);
	    private static final String FILE_PATH_JSON_NOTAS = "Cevallos_Promedio.json";
	    private static final String FILE_PATH_CSV_NOTAS = "Cevallos_Promedio.csv";
	    private static final String FILE_PATH_JSON_RESULT = "Cevallos_Promedio_Result.json";
	    private static final String FILE_PATH_CSV_RESULT = "Cevallos_Promedio_Result.csv";

	    public static void main(String[] args) {
	        menu();
	    }

	    public static void menu() {
	        int opc;
	        do {
	            System.out.println("=======MENU=========");
	            System.out.println("1. INGRESO DE LAS NOTAS");
	            System.out.println("2. RESULTADO DE PROMEDIOS");
	            System.out.println("3. SALIR");
	            System.out.println("INGRESE SU OPCION: ");
	            opc = scanner.nextInt();

	            switch (opc) {
	                case 1:
	                    datos();
	                    break;
	                case 2:
	                    promedio();
	                    break;
	                case 3:
	                    System.out.println("Gracias por usar el programa");
	                default:
	                    System.out.println("El dato ingresado es incorrecto, ingrese nuevamente");
	            }
	        } while (opc!=3);
	    }

	    public static void datos() {
	        do {
	            System.out.println("Ingrese el primer promedio (0 a 20)");
	            notas1 = scanner.nextFloat();
	        } while (notas1 < 0 || notas1 > 20);

	        do {
	            System.out.println("Ingrese el segundo promedio (0 a 20)");
	            notas2 = scanner.nextFloat();
	        } while (notas2 < 0 || notas2 > 20);

	        do {
	            System.out.println("Ingrese el tercer promedio (0 a 20)");
	            notas3 = scanner.nextFloat();
	        } while (notas3 < 0 || notas3 > 20);

	        // Guardar en CSV
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_CSV_NOTAS))) {
	            writer.write("Tipo,Valor\n");
	            writer.write("NOTAS 1," + notas1 + "\n");
	            writer.write("NOTAS 2," + notas2 + "\n");
	            writer.write("NOTAS 3," + notas3 + "\n");
	            System.out.println("Notas registradas en el archivo " + FILE_PATH_CSV_NOTAS);
	        } catch (IOException e) {
	            System.out.println("Error al guardar el archivo CSV: " + e.getMessage());
	        }

	        // Guardar en JSON
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_JSON_NOTAS))) {
	            writer.write("{\n");
	            writer.write("    \"notas1\": " + notas1 + ",\n");
	            writer.write("    \"notas2\": " + notas2 + ",\n");
	            writer.write("    \"notas3\": " + notas3 + "\n");
	            writer.write("}");
	            System.out.println("Notas registradas en el archivo " + FILE_PATH_JSON_NOTAS);
	        } catch (IOException e) {
	            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
	        }
	    }

	    public static void promedio() {
	        result = (notas1 + notas2 + notas3) / 3;
	        String estado = (result >= 14) ? "aprobado" : "reprobado";

	        // Guardar en CSV
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_CSV_RESULT))) {
	            writer.write("Tipo,Valor\n");
	            writer.write("Promedio," + result + "\n");
	            writer.write("Estado," + estado + "\n");
	            System.out.println("Promedio registrado en el archivo " + FILE_PATH_CSV_RESULT);
	        } catch (IOException e) {
	            System.out.println("Error al guardar el archivo CSV: " + e.getMessage());
	        }

	        // Guardar en JSON
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_JSON_RESULT))) {
	            writer.write("{\n");
	            writer.write("    \"promedio\": " + result + ",\n");
	            writer.write("    \"estado\": \"" + estado + "\"\n");
	            writer.write("}");
	            System.out.println("Promedio registrado en el archivo " + FILE_PATH_JSON_RESULT);
	        } catch (IOException e) {
	            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
	        }
	    }
	}