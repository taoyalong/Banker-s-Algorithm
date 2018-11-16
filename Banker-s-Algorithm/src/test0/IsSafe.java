package test0;

public class IsSafe {

	@SuppressWarnings("static-access")
	public static boolean issafe() {
		Main main = new Main();
		int[] work = main.valiable;
		boolean[] Finish = new boolean[5];
		for (int i = 0; i < 3; i++) {
			Finish[i] = false;
		}
/*		System.out.println("已分配资源数");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(main.allocation[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("剩余需求资源数");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(main.need[i][j] + "\t");
			}
			System.out.println();
		}
*/
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (Finish[i] == false&& main.need[i][j] <= work[j]) {
					System.out.println(Finish[i] + "\t" + main.need[i][j]
							+ "\t" + work[j]);
					work[j] = work[j] + main.allocation[i][j];
					Finish[i] = true;
				}
			}
		}
		for (int i = 0; i < Finish.length; i++) {
			if (Finish[i] = true) {
				continue;
			}
			if (Finish[i] = false) {
				return false;
			}
		}
		return true;

	}
}
