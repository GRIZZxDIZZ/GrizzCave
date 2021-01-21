#include <stdlib.h>
#include <stdio.h>

// T(0) = c0 when n = 0
// T(n) = c1 + T(n-1) recurrence relation when n > 0.  T(n-1) = c1+T((n-1)-1)
//      = c1 + (c1 + T(n-2))
//      = c1 + c1+ (c1 + t(n-3))
//
unsigned int factorial(unsigned int facts)
{
	// Base Case
	if (facts == 0)
		return 1;

	return factorial(facts - 1) * facts;
}

int find_max(int *array, int n)
{
	int bigger;

	// Base Case
	if (n == 1)
		return array[0];

	bigger = max(find_max(array, n-1), array[n-1]);
	return bigger; 
}
int main (void)
{
	int n = 6;
	int array[] = {43, 8, 11, 12, 2, 26};

	printf("%d\n", find_max(array, n));
	return 0;
}