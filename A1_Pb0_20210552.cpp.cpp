#include <iostream>
#include<cstring>
#include <string>
#include<algorithm>
#include<cstdio>
#include<cctype>
using namespace std;
int main() {
    char sent[1000];
    char str[100][100];
    int i = 0, j, k;
    cout << "Welcome,plz enter the sentence. write -1 if u wanna stop!! (on a new line). " << endl;
    while (cin.getline(str[i], 100)) {
        if (str[i][0] == '-' && str[i][1] == '1') {
            break;
        }
        i++;
    }
    for (j = 0; j<i; j++) {
        for (k = 0; str[j][k]!='\0'; k++) {
            str[i][j] = tolower(str[j][k]);
        }
    }
    char last;
    last = '.';
    int s=0;
    str[0][0] = toupper(str[0][0]);
    for (j = 0; j<i; j++) {
        for (k = 0; str[j][k] != '\0'; k++) {
            if (str[j][k] == ' ' && last == ' '){
                continue;

            }
            if(last == '.'){
                sent[s++]= toupper(str[j][k]);
            }
            else{
                sent[s++]= tolower(str[j][k]);
            }
            last=sent[s-1];
        }
    }
    sent[s]='\0';
    sent[0]= toupper(sent[0]);
    for(int i=0; i< strlen(sent); i++) {
        cout<<sent[i];
    }
}