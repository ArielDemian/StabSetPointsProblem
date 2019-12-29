import java.util.LinkedList;
import java.util.List;

public class StabSetPoints {

	public static void main(String[] args) {
		double[][] X = { { 1, 4 }, { 4, 5 }, { 7, 9 }, { 9, 12 }, { 4, 9 }, { 12, 13 } };
		StabSetPoints s = new StabSetPoints();
		double[] res = s.stabs(X);
		for (int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}

	public double[] stabs(double[][] X) {
		boolean[] stabbed = new boolean[X.length];
		List<double[]> l = new LinkedList<double[]>();
		for (int i = 0; i < X.length; i++) {
			if (stabbed[i])
				continue;
			double[] temp = X[i];
			for (int y = i + 1; y < X.length; y++) {
				if (temp[0] > X[y][0] && temp[0] > X[y][1] || temp[1] < X[y][0] && temp[1] < X[y][1]) {
					continue;
				} else {
					stabbed[y] = true;
					if (temp[0] < X[y][0])
						temp[0] = X[y][0];
					if (temp[1] > X[y][1])
						temp[1] = X[y][1];
				}
			}
			stabbed[i] = true;
			l.add(temp);
		}
		double[] res = new double[l.size()];
		for (int i = 0; i < l.size(); i++) {
			res[i] = l.get(i)[0];
		}
		return res;
	}
}
