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
		// Avaliable赋值
		System.out.println("请输入A可利用资源数");
		int a = input.nextInt();
		System.out.println("请输入B可利用资源数");
		int b = input.nextInt();
		System.out.println("请输入C可利用资源数");
		int c = input.nextInt();
		valiable[0] = a;
		valiable[1] = b;
		valiable[2] = c;

		System.out.println("进程剩余可利用资源数");
		for (int i = 0; i < 3; i++) {
			System.out.print(valiable[i] + "\t");
		}
		System.out.println();
		// allocation赋值

		System.out.println("请输入已分配资源数");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				allocation[i][j] = input.nextInt();
			}
		}

		System.out.println("已分配资源数");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(allocation[i][j] + "\t");
			}
			System.out.println();
		}
		// allocation赋值

		System.out.println("请输入最大需求资源数");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				max[i][j] = input.nextInt();
			}
		}

		System.out.println("最大需求资源数");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(max[i][j] + "\t");
			}
			System.out.println();
		}
		// 剩余需求资源数

		System.out.println("请输入剩余需求资源数");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				need[i][j] = input.nextInt();
			}
		}

		/* System.out.println("剩余需求资源数"); */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(need[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("请输入i进程编号");
		jinchengi = input.nextInt();
		System.out.println("请输入i进程需求量");
		for (int i = 0; i < request.length; i++) {
			request[i] = input.nextInt();
		}
		for (int i = 0; i < request.length; i++) {
			System.out.println(request[i]);
		}
		System.out.println("\n");
		// 遍历进程资源j进程操作
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
			System.out.println("状态安全");
		}
	}
}
