//
//  double_text.cpp
//  Labs
//
//  Created by Maksym Davydov on 2/19/16.
//
//

#include <stdio.h>
#include <time.h>


const double count = 100000000;

void test1()
{
    printf("Using double...\n");
    double sum = 0;
    
    clock_t start = clock();
    for(double i=1; i<=count; ++i)
    {
        sum += 1.0/i;
    }
    clock_t num_clocks = clock() - start;
    
    printf("sum = %lf\n", sum);
    printf ("It took me %f seconds.\n", ((float)num_clocks)/CLOCKS_PER_SEC );
}

void test2()
{
    printf("Using automatic vectorization...\n");
    double sum1 = 0.0;
    double sum2 = 0.0;
    double sum3 = 0.0;
    double sum4 = 0.0;
    clock_t start = clock();
    {
        int icount = int(count);
        double end = icount - (icount%4);
        for(double i=1; i<=end; i+=4)
        {
            sum1 += 1.0/i;
            sum2 += 1.0/(i+1);
            sum3 += 1.0/(i+2);
            sum4 += 1.0/(i+3);
        }
        
        for(double i = 1 + end; i<=count; ++i)
        {
            sum4 += 1.0/i;
        }
    }
    
    double sum = sum1 + sum2 + sum3 + sum4;
    clock_t num_clocks = clock() - start;
    
    printf("sum = %lf\n", sum);
    printf ("It took me %f seconds.\n", ((float)num_clocks)/CLOCKS_PER_SEC );
}

int main()
{
    test1();
    test2();
}
