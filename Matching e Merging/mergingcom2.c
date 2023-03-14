//merging com 2 vetores
#include <stdio.h>
#include<stdbool.h>
#define MEMORIA 100000000
bool NUMERO=true;


int input(FILE *arq, int proximo){
	int flag, chave;
	flag=fscanf(arq, "%d", &chave); //lê o elemento no arquivo
	if(flag==EOF){
		chave=MEMORIA;
		if(proximo==MEMORIA){
			NUMERO=false; //verifica se a lista foi finalizada
		}
	}
	return chave;
}

int main (void){
	int chave1=0, chave2=0;
	FILE *arq1, *arq2, *arqsaida;
	arq1=fopen("arq1.txt", "r"); //abre o arquivo 1
	arq2=fopen("arq2.txt", "r"); //abre o arquivo 2
	arqsaida=fopen("arqsaida.txt", "w"); //cria o arquivo de saída
	chave1=input(arq1, chave2); //lê o primeiro do arquivo 1
	chave2=input(arq2, chave1); //lê o primeiro do arquivo 2
	while (NUMERO){ //enquanto existe numero no arquivo
		if(chave1<chave2){ 
			fprintf(arqsaida, "%d\n", chave1); //escreve no arquivo saída
			chave1=input(arq1, chave2); //lê o proximo do arquivo 1
		}else if(chave2<chave1){
			fprintf(arqsaida, "%d\n", chave2); //escreve no arquivo saída
			chave2=input(arq2, chave1); //lê o proximo do arquivo 2
		}else{
			fprintf(arqsaida, "%d\n", chave1); //escreve no arquivo saída
			chave1=input(arq1, chave2); //lê o proximo do arquivo 1
			chave2=input(arq2, chave1); //lê o proximo do arquivo 2
		}
	}
}
