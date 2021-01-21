#include <stdlib.h>
#include <stdio.h>

void printArr(int arr[], int size)
{
	for(int c = 0; c < size; c++)
	{
		printf("%d ", arr[c]);
	}
	printf("\n");
}

void selectSort(int arr[], int size)
{
	int i,j,min,hold;

		for (i = 0; i < size-1; ++i)
		{
			min = i;
			for (j = i+1; j < size; j++)
			{
				
				if(arr[j] < arr[min])
				{
					min = j;
				}
			}

			hold = arr[i];
			arr[i] = arr[min];
			arr[min] = hold;
		}

		printArr(arr, size);
	}

int main()
{
	int arr[6];
	int input;

	for(int d = 0; d < 6; d++)
	{
		input = rand() % 20 + 1;
		arr[d] = input;
	}

	printf("Old array is:\n");
	printArr(arr, 6);

	printf("New array is:\n");
	selectSort(arr,6);

	return 0;

}