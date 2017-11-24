//
// Created by czk on 11/21/17.
//

#include <stdio.h>
#include <string.h>
#include <malloc.h>


char* longestParlindrome(char *s){
    char *lp = malloc(sizeof(char) * 1001);
    int width = (int)strlen(s);
    int result[width][width];

    // Initialize the DP
    for(int i = 0;i < width;i++){
        for(int j = 0;j < width;j++){
            result[i][j] = 0;
            if (i == j){
                result[i][j] = 1;
            }
            if (j == i + 1){
                result[i][j] = (s[i] == s[j]) ? (1) : (0);
            }
        }
    }

    // DP step
    for(int i = width - 1;i >= 0;i--){
        //no need to check the last two lines
        for(int j = width - 1;j > i + 1;j-- ){
            result[i][j] = (s[i] == s[j]) ? (result[i + 1][j - 1]) : (0);
        }

    }

    int max_length = 0;
    int max_i, max_j;
    // Get the result
    for(int i = width - 1;i >= 0;i--){
        for(int j = width - 1; j >= i;j--){
            if (!result[i][j]) continue;
            int length = j - i + 1;
            if (length > max_length){
                max_length = length;
                max_i = i;
                max_j = j;
            }
        }
    }

    memcpy(lp, &s[max_i], max_length);
    lp[max_length] = '\0';
    printf("The longest parlindrom should be :%s\n", lp);
    return lp;


}


int main(void){
    char test[] = "cbbcacbbc";
    char *result = longestParlindrome(test);
    free(result);
    return 0;
}