#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2){
        int l1 = nums1.size();
        int l2 = nums2.size();
        if (l1 > l2){
            nums1.swap(nums2);
            int temp = l1;
            l1 = l2;
            l2 = temp;
        }

        int imin = 0, imax = l1;
        int i, j;
        while(imin <= imax){
            i = (imin + imax) / 2;
            j = (l1 + l2 + 1) / 2 - i;

            if(i < l1 && nums1[i] < nums2[j - 1]){
                imin = i + 1;
            } else if (i > 0 && nums2[j] < nums1[i - 1]){
                imax = i -1;
            } else {
                int max_left, min_right;
                if (i == 0) {
                    // In this case, the left should be a and b[0] to b[j - 1]
                    max_left = nums2[j - 1];
                } else if (j == 0){
                    // In this case, the left should be a[0] to a[i - 1]
                    max_left = nums1[i - 1];
                } else {
                    max_left = max(nums1[i - 1], nums2[j - 1]);
                }

                if ((l1 + l2) % 2 == 1)
                    return max_left;
                if (i == l1){
                    min_right = nums2[j];
                } else if (j == l2){
                    min_right = nums1[i];
                } else {
                    min_right = min(nums1[i], nums2[j]);
                }

                return (max_left + min_right) / 2.0;
            }
        }
    }
};

int main(void){
    Solution sol = Solution();
    int a1[] = {1,2,3};
    int a2[] = {4,5,6};
    vector<int> v1(a1, a1 + sizeof(a1) / sizeof(a1[0]));
    vector<int> v2(a2, a2 + sizeof(a2) / sizeof(a2[0]));
    double ans = sol.findMedianSortedArrays(v1, v2);
    cout << ans << endl;
}