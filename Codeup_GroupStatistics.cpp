#include <cstdio>
#include <map>
#include <set>

using namespace std;

int main() {
	int m;
	scanf("%d", &m);
	while (m-- > 0) {
		int a[101], n;
		int k;
		map<int, map<int, int> > mp;
		set<int> st;
		scanf("%d", &n);
		for (int i = 0; i < n; i++) {
			scanf("%d", &k);
			a[i] = k;
			st.insert(k);
		}
		for (int i = 0; i < n; i++) {
			scanf("%d", &k);
			mp[k][a[i]]++;
		}
		for (map<int, map<int, int> >::iterator it = mp.begin(); it != mp.end(); it++) {
			int key = it->first;
			map< int, int > subs = it->second;
			printf("%d={", key);
			int sn = st.size(), si = 0;
			for (set<int>::iterator it2 = st.begin(); it2 != st.end(); it2++) {
				int key2 = *it2;
				printf("%d=", key2);
				map<int, int>::iterator it3 = subs.find(key2);
				printf("%d", it3->second);
				si++;
				if (si != sn) {
					printf(",");
				}
			}
			printf("}\n");
		}
	}
	return 0;
}
