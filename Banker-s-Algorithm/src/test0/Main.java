package test0;

import java.util.Scanner;

public class Main {

	static int[][] allocation = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 },
			{ 2, 1, 1 }, { 0, 0, 2 } };
	static int[][] max = { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 },
			{ 4, 3, 3 } };
	static int[][] need = { { 7, 4, 5 }, { 1, 2, 2 }, { 6, 0, 0 }, { 0, 1, 1 },
			{ 4, 3, 1 } };
	static int[] valiable = { 3, 3, 2 };
	static int[] request = { 1, 0, 2 };
	static int jinchengi;

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		IsSafe isSafe = new IsSafe();
		Scanner input = new Scanner(System.in);
		// Avaliable��ֵ
		System.out.println("������A��������Դ��");
		int a = input.nextInt();
		System.out.println("������B��������Դ��");
		int b = input.nextInt();
		System.out.println("������C��������Դ��");
		int c = input.nextInt();
		valiable[0] = a;
		valiable[1] = b;
		valiable[2] = c;

		System.out.println("����ʣ���������Դ��");
		for (int i = 0; i < 3; i++) {
			System.out.print(valiable[i] + "\t");
		}
		System.out.println();
		// allocation��ֵ

		System.out.println("�������ѷ�����Դ��");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				allocation[i][j] = input.nextInt();
			}
		}

		System.out.println("�ѷ�����Դ��");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(allocation[i][j] + "\t");
			}
			System.out.println();
		}
		// allocation��ֵ

		System.out.println("���������������Դ��");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				max[i][j] = input.nextInt();
			}
		}

		System.out.println("���������Դ��");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(max[i][j] + "\t");
			}
			System.out.println();
		}
		// ʣ��������Դ��

		System.out.println("������ʣ��������Դ��");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				need[i][j] = input.nextInt();
			}
		}

		/* System.out.println("ʣ��������Դ��"); */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(need[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("������i���̱��");
		jinchengi = input.nextInt();
		System.out.println("������i����������");
		for (int i = 0; i < request.length; i++) {
			request[i] = input.nextInt();
		}
		for (int i = 0; i < request.length; i++) {
			System.out.println(request[i]);
		}
		System.out.println("\n");
		// ����������Դj���̲���
		for (int j = 0; j < 3; j++) {
			if (request[j] <= need[jinchengi][j]) {
				if (request[j] <= valiable[j]) {
					valiable[j] = valiable[j] - request[j];
					allocation[jinchengi][j] = allocation[jinchengi][j]
							+ request[j];
					need[jinchengi][j] = need[jinchengi][j] - request[j];
				}

			}

		}

		boolean safe = IsSafe.issafe();
		if (safe == false) {
			for (int j = 0; j < 3; j++) {

				valiable[j] = valiable[j] + request[j];
				allocation[jinchengi][j] = allocation[jinchengi][j]
						- request[j];
				need[jinchengi][j] = need[jinchengi][j] + request[j];

			}
		} else {
			System.out.println("״̬��ȫ");
		}
	}
}
