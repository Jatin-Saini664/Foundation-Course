class shortestCommonSupersequence
{
public:
    string shortestCommonSupersequence(string str1, string str2)
    {
        string s = "";
        string p = LCS(str1, str2);
        int x = 0, y = 0, z = 0;
        while (z < p.length())
        {
            while (str1[x] != p[z])
                s += str1[x], x++;
            while (str2[y] != p[z])
                s += str2[y], y++;
            s += p[z];
            x++;
            y++;
            z++;
        }
        while (x < str1.length())
            s += str1[x], x++;
        while (y < str2.length())
            s += str2[y], y++;
        return s;
    }
    string LCS(string word1, string word2)
    {
        int n = word1.length();
        int m = word2.length();
        vector<vector<string>> dp(word1.length() + 1, vector<string>(word2.length() + 1, ""));
        for (int i = 0; i <= word1.length(); i++)
        {
            for (int j = 0; j <= word2.length(); j++)
            {
                if (i == 0 || j == 0)
                {
                    dp[i][j] = "";
                    continue;
                }
                if (word1[i - 1] == word2[j - 1])
                {
                    dp[i][j] = dp[i - 1][j - 1] + word1[i - 1];
                }
                else
                {
                    if (dp[i][j - 1].length() > dp[i - 1][j].length())
                        dp[i][j] = dp[i][j - 1];
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
};