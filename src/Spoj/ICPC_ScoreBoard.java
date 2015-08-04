package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ICPC_ScoreBoard {
	static class Team implements Comparable<Team> {
		int solved, index;
		long failedAttempts;
		long totalPen, timePen;

		Team(int i) {
			index = i;
		}

		long totalPenality(long errorPen) {
			long res = timePen + (errorPen * failedAttempts);
			return res;
		}

		@Override
		public int compareTo(Team t) {
			if (solved > t.solved)
				return -1;
			if (solved < t.solved)
				return 1;
			if (totalPen > t.totalPen)
				return 1;
			if (totalPen < t.totalPen)
				return -1;
			if (index > t.index)
				return 1;
			if (index < t.index)
				return -1;
			return 0;
		}

		public String toString() {
			return index + " " + totalPen;
		}
	}

	static Team[] teams;
	static int originalStandings[][];
	static long MAX = 1000000000000L;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[], currProblem[];
		int t, p, i;
		long lo, hi, mid, g, h;

		while (true) {
			l = bf.readLine().split(" ");
			t = Integer.parseInt(l[0]);
			p = Integer.parseInt(l[1]);
			teams = new Team[t];
			originalStandings = new int[2][t];
			if (t + p == 0)
				break;
			for (i = 0; i < t; i++) {
				teams[i] = new Team(i);
				l = bf.readLine().split(" ");
				for (int j = 0; j < p; j++) {
					currProblem = l[j].split("/");
					if (currProblem[1].charAt(0) == '-')
						continue;
					teams[i].solved++;
					teams[i].failedAttempts += Integer.parseInt(currProblem[0]);
					teams[i].timePen += Integer.parseInt(currProblem[1]);
				}
				teams[i].totalPen = teams[i].totalPenality(20);
			}
			Arrays.sort(teams);
			int rank = 0;
			originalStandings[0][0] = teams[0].index;
			originalStandings[1][0] = rank;
			for (i = 1; i < t; i++) {
				if (!(teams[i].totalPen == teams[i - 1].totalPen && teams[i].solved == teams[i - 1].solved))
					rank++;
				originalStandings[0][i] = teams[i].index;
				originalStandings[1][i] = rank;
			}
			int min = 20;
			for (int j = 1; j < 20; j++) {
				if (check(j)) {
					min = j;
					break;
				}
			}
			lo = 20;
			hi = MAX + 1;
			while (lo + 1 < hi) {
				mid = (lo + hi) / 2;
				if (check(mid)) {
					lo = mid;
				} else {
					hi = mid;
				}
			}
			System.out.println(min + " " + ((lo == MAX) ? "*" : lo));
		}
	}

	static boolean check(long error) {
		for (int i = 0; i < teams.length; i++) {
			teams[i].totalPen = teams[i].totalPenality(error);
		}
		int ranks[] = new int[teams.length];
		int rank = 0;
		Arrays.sort(teams);
		for (int i = 1; i < teams.length; i++) {
			if (!(teams[i].totalPen == teams[i - 1].totalPen && teams[i].solved == teams[i - 1].solved))
				rank++;
			ranks[i] = rank;
		}
		for (int i = 0; i < teams.length; i++) {
			if (originalStandings[0][i] != teams[i].index
					|| originalStandings[1][i] != ranks[i])
				return false;
		}
		return true;
	}
}