class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.empty()) return 0;

        map<char, int> lastSeen; 
        int maxLen = 0;
        int left   = 0;        

        for (int right = 0; right < s.size(); right++)
        {
            char current = s[right];

            if (lastSeen.count(current) && lastSeen[current] >= left)
            {
                left = lastSeen[current] + 1;
            }

            lastSeen[current] = right;

            int windowSize = right - left + 1;
            maxLen = max(maxLen, windowSize);
        }

        return maxLen;
    }
};