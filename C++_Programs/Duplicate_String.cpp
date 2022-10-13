#include <stdio.h>
#include<stdint.h>
// this function only works for lower case alphabets
void duplicates (char *s) {
    
    // We need 26 bits, but we can get it only in bytes, so we get 32 bits
    // Similar idea to the "hashing" using array
    uint32_t H = 0;
    
    for (int i = 0; s[i] != '\0'; i++) {
        uint32_t x = 1;
        
        x = x << (s[i] - 97); // Moving x to the appropriate place
        
        // Masking so that we can check
        if (H & x) // if H AND x is greater than 0.
            printf("%c is a duplicate\n",s[i]);
        // Else, Merging 
        else
            H = H | x;
    }
}

int main() {
    char s[] = "radar";
    duplicates(s);
}
