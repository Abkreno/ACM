#include <cstdio>
#include <cstring>
#include <math.h>
#include <algorithm>
using namespace std;
#define MAX 50007
int par[MAX];
struct Node {
	int max, prefix, suffix, sum;
};
Node tree[MAX << 2];
Node merge(Node a, Node b) {
	Node res;
	res.sum = a.sum + b.sum;
	res.max = max(a.max, b.max);
	res.max = max(res.max, a.suffix + b.prefix);
	res.prefix = max(a.prefix, a.sum + b.prefix);
	res.suffix = max(b.suffix, a.suffix + b.sum);
	return res;
}
void buildTree(int ind, int st, int ed) {
	if (st == ed) {
		int X;
		scanf("%d", &X);
		tree[ind].sum = tree[ind].max = tree[ind].prefix = tree[ind].suffix = X;
		par[st] = ind;
		return;
	}
	int l = ind << 1;
	int r = l + 1;
	int mid = (st + ed) / 2;
	buildTree(l, st, mid);
	buildTree(r, mid + 1, ed);
	tree[ind] = merge(tree[l], tree[r]);
}

Node queryTree(int ind, int st, int ed, int i, int j) {
	if (st == i && ed == j)
		return tree[ind];
	int l = ind << 1;
	int r = l + 1;
	int mid = (st + ed) / 2;
	if (mid < i) {
		return queryTree(r, mid + 1, ed, i, j);
	} else if (mid >= j) {
		return queryTree(l, st, mid, i, j);
	} else {
		return merge(queryTree(l, st, mid, i, mid),
				queryTree(r, mid + 1, ed, mid + 1, j));
	}
}
void updateTree(int node, int val) {
	int ind = par[node];
	tree[ind].sum = tree[ind].max = tree[ind].prefix = tree[ind].suffix = val;
	while ((ind = ind >> 1) > 0) {
		int l = ind << 1;
		int r = l + 1;
		tree[ind] = merge(tree[l], tree[r]);
	}
}
int main() {
	int N, Q;
	while (scanf("%d", &N) == 1) {
		buildTree(1, 1, N);
		scanf("%d", &Q);
		int a, b, c;
		while (Q--) {
			scanf("%d %d %d", &a, &b, &c);
			if (a) {
				printf("%d\n", queryTree(1, 1, N, b, c).max);
			} else {
				updateTree(b, c);
			}
		}
	}
	return 0;
}
