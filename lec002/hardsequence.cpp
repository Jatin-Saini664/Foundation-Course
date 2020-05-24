#include <iostream>
using namespace std;

int main()
{
    int T, N, a[128], i = 0, c = 0, pos = 0;
    cin >> T;
    a[0] = 0, a[1] = 0;
    for (i = 2; i < 128; i++)
    {
        pos = 0;
        for (int j = 0; j < i - 2; j++)
        {
            if (a[j] == a[i - 1])
            {
                pos = j;
            }
        }
        a[i] = i - 1 - pos;
    }
    while (T--)
    {
        c = 0;
        cin >> N;
        for (i = 0; i < N; i++)
        {
            if (a[N - 1] == a[i])
                c++;
        }
        cout << c;
    }
    return 0;
}
