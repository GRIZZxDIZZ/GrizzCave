#include <stdlib.h>
#include <stdio.h>


void truswap (int* a, int* b)
{
	int temp;

	temp = *a;
	*a = *b;
	*b = temp;
}

int main(char** argv, int argc)
{
	int i , j;

	printf("enter your first number ");
	scanf("%i", &i);
	printf("\n");

	printf("enter your second number ");
	scanf("%i", &j);
	printf("\n");

	printf("i holds: %i and j holds: %i \n", i, j);

	truswap(&i, &j);

	printf("i holds: %i and j holds: %i \n", i, j);

	exit(0);

}