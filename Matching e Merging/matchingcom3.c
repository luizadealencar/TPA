//matching com 3 vetores
#include <stdio.h>
#include<stdbool.h>
bool NUMERO = true;

int input (FILE *pt_arq){
    int flag, chave;
    flag=fscanf(pt_arq, "%d", &chave); //lê o elemento no arquivo
    if (flag==EOF){
        NUMERO=false;  //verifica se a lista foi finalizada
    }
    return chave;
}

int main (void){
	int chave1=0, chave2=0, chave3=0;
	FILE *arq1, *arq2, *arq3, *arqsaida;
	arq1=fopen("arq1.txt", "r"); //abre o arquivo 1
	arq2=fopen("arq2.txt", "r"); //abre o arquivo 2
	arq3=fopen("arq3.txt", "r"); //abre o arquivo 3
	arqsaida=fopen("arqsaida.txt", "w"); //cria o arquivo de saída
	chave1=input(arq1); //lê o primeiro do arquivo 1
	chave2=input(arq2); //lê o primeiro do arquivo 2
	chave3=input(arq3); //lê o primeiro do arquivo 3
	while (NUMERO){ //enquanto existe numero no arquivo
		if(chave1<chave2 || chave1<chave3){
			chave1=input(arq1); //lê o proximo do arquivo 1
		}else if(chave2<chave1 || chave2<chave3){
			chave2=input(arq2); //lê o proximo do arquivo 2
		}else if(chave3<chave1 || chave3<chave2){
			chave3=input(arq3); //lê o proximo do arquivo 3
		}else{
			fprintf(arqsaida, "%d\n", chave1); //escreve no arquivo saída
			chave1=input(arq1); //lê o proximo do arquivo 1
			chave2=input(arq2); //lê o proximo do arquivo 2
			chave3=input(arq3); //lê o proximo do arquivo 3
		}
	}
}