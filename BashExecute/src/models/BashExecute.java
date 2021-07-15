package models;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BashExecute {

	private Scanner scanner;

	public BashExecute() {
		scanner = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("Bienvenido");
		System.out.println("Digite la opcion deseada");
		System.out.println("1. Conectar al servidor");
		System.out.println("2. Salir");
		options(Integer.parseInt(scanner.nextLine()));
	}

	private void options(int op) {
		switch (op) {
		case 1:
			connectToServer();
			break;
		case 2:
			System.exit(0);
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}
	}

	private void connectToServer() {
		Process process;
		try {
			System.out.println("Ingrese nombre");
			String name = scanner.nextLine();
			System.out.println("Ingrese ip");
			String ip = scanner.nextLine();
			String conn = "ssh "+name+"@"+ip+" 'bash -s' < conditional.sh";
			process = Runtime.getRuntime().exec(conn);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BashExecute be = new BashExecute();
		be.showMenu();
	}
}
