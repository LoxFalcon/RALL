#include<stdio.h>
#include<stdlib.h>
struct _stackInt{
	int* data;
	int tope;
	int capacidad;
};
struct _stackFloat{
	float* data;
	int tope;
	int capacidad;
};
struct _stackChar{
	char* data;
	int tope;
	int capacidad;
};

struct _queueInt{
	int* data;
	int frente;
	int fin;
	int capacidad;
};

struct _queueFloat{
	float* data;
	int frente;
	int fin;
	int capacidad;
};

struct _queueChar{
	char* data;
	int frente;
	int fin;
	int capacidad;
};

int _popInt(struct _stackInt s){
	if(s.tope == -1){
		printf("ERROR Stack vacío\n");
		exit(EXIT_FAILURE);
	}
	return s.data[s.tope--];
}

float _popFloat(struct _stackFloat s){
	if(s.tope == -1){
		printf("ERROR Stack vacío\n");
		exit(EXIT_FAILURE);
	}
	return s.data[s.tope--];
}

char _popChar(struct _stackChar s){
	if(s.tope == -1){
		printf("ERROR Stack vacío\n");
		exit(EXIT_FAILURE);
	}
	return s.data[s.tope--];
}

int _frontInt(struct _queueInt q){
	if(q.frente==-1 || q.fin==-1){
		printf("ERROR Cola vacía\n");
		exit(EXIT_FAILURE);
	}
	int retVal = q.data[q.frente];
	if(q.frente == q.fin){ //Se vacía la cola
		q.frente = -1;
		q.fin = -1; 		
	}else{
		q.frente = (q.frente + 1) % q.capacidad;
	} 
	return retVal;
}

float _frontFloat(struct _queueFloat q){
	if(q.frente==-1 || q.fin==-1){
		printf("ERROR Cola vacía\n");
		exit(EXIT_FAILURE);
	}
	float retVal = q.data[q.frente];
	if(q.frente == q.fin){ //Se vacía la cola
		q.frente = -1;
		q.fin = -1; 		
	}else{
		q.frente = (q.frente + 1) % q.capacidad;
	} 
	return retVal;
}

char _frontChar(struct _queueChar q){
	if(q.frente==-1 || q.fin==-1){
		printf("ERROR Cola vacía\n");
		exit(EXIT_FAILURE);
	}
	char retVal = q.data[q.frente];
	if(q.frente == q.fin){ //Se vacía la cola
		q.frente = -1;
		q.fin = -1; 		
	}else{
		q.frente = (q.frente + 1) % q.capacidad;
	} 
	return retVal;
}

void _pushInt(struct _stackInt s, int valor){
	if(s.tope>=s.capacidad){
		printf("ERROR Stack lleno\n");
		exit(EXIT_FAILURE);
	}
	s.data[++s.tope] = valor;
}

void _pushFloat(struct _stackFloat s, float valor){
	if(s.tope>=s.capacidad){
		printf("ERROR Stack lleno\n");
		exit(EXIT_FAILURE);
	}
	s.data[++s.tope] = valor;
}

void _pushChar(struct _stackChar s, char valor){
	if(s.tope>=s.capacidad){
		printf("ERROR Stack lleno\n");
		exit(EXIT_FAILURE);
	}
	s.data[++s.tope] = valor;
}

void _enqueueInt(struct _queueInt q, int valor){
	int newIndex = (q.fin + 1) % q.capacidad;
	if(newIndex == q.frente){
		printf("ERROR Cola llena\n");
		exit(EXIT_FAILURE);
	}
	q.data[newIndex] = valor;
}

void _enqueueFloat(struct _queueFloat q, float valor){
	int newIndex = (q.fin + 1) % q.capacidad;
	if(newIndex == q.frente){
		printf("ERROR Cola llena\n");
		exit(EXIT_FAILURE);
	}
	q.data[newIndex] = valor;
}

void _enqueueChar(struct _queueInt q, char valor){
	int newIndex = (q.fin + 1) % q.capacidad;
	if(newIndex == q.frente){
		printf("ERROR Cola llena\n");
		exit(EXIT_FAILURE);
	}
	q.data[newIndex] = valor;
}

void _initStackInt(struct _stackInt s, int capacidad){
	s.tope = -1;
	s.capacidad = capacidad;
	s.data = (int*)malloc(capacidad*sizeof(int));
}

void _initStackFloat(struct _stackFloat s, int capacidad){
	s.tope = -1;
	s.capacidad = capacidad;
	s.data = (float*)malloc(capacidad*sizeof(float));
}

void _initStackChar(struct _stackChar s, int capacidad){
	s.tope = -1;
	s.capacidad = capacidad;
	s.data = (char*)malloc(capacidad*sizeof(char));
}

void _initQueueInt(struct _queueInt q, int capacidad){
	q.frente = -1;
	q.fin = -1;
	q.capacidad = capacidad;
	q.data = (int*)malloc(capacidad*sizeof(int));
}


void _initQueueFloat(struct _queueFloat q, int capacidad){
	q.frente = -1;
	q.fin = -1;
	q.capacidad = capacidad;
	q.data = (float*)malloc(capacidad*sizeof(float));
}

void _initQueueChar(struct _queueChar q, int capacidad){
	q.frente = -1;
	q.fin = -1;
	q.capacidad = capacidad;
	q.data = (char*)malloc(capacidad*sizeof(char));
}

int main(){
return 0;
}

