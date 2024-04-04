public class Prob_02 {
    public static void main(String[] args) {


        int []X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
        int []Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };

        int max1=Math.max(findMax(X,Y,1,0,X[0],1),findMax(X,Y,0,1,Y[0],-1));

        System.out.println(max1);

    }
    public static int findMax(int []x,int []y,int i,int j,int sum,int term)
    {
         if(term==1)
         {
             if(i==x.length-1){
                 return sum+x[i];
             }
             if(x[i]<y[j])
             {
                 if(j==y.length-1)
                 {
                     while(i<x.length)
                     {
                         sum+=x[i];
                         i++;
                     }
                     return sum;
                 }
                 else
                 {
                     return findMax(x,y,i+1,j,sum+x[i],term);
                 }

             }
             else if(x[i]>y[j])
             {
                  while(j<y.length && y[j]<x[i])
                  {
                      j++;
                  }
                  if(y[j]==x[i]){
                     return  Math.max(findMax(x,y,i+1,j,sum+x[i],term),findMax(x,y,i,j+1,sum+y[j],-1));
                  }
                  else
                  {
                      if(j==y.length-1) {
                          while(i<x.length)
                          {
                              sum+=x[i];
                              i++;
                          }
                          return sum;
                      }
                      else
                      {
                          return findMax(x,y,i+1,j,sum+x[i],term);
                      }
                  }
             }
             else if(x[i]==y[j])
             {
                return  Math.max(findMax(x,y,i+1,j,sum+x[i],term),findMax(x,y,i,j+1,sum+y[j],-1));
             }
         }
         else if(term==-1)
         {
             if(j==y.length-1){
                 return sum+y[j];
             }
             if(x[i]>y[j])
             {
                 if(i==x.length-1)
                 {
                     while(j<y.length)
                     {
                         sum+=y[j];
                         j++;
                     }
                     return sum;
                 }
                 else
                 {
                     return findMax(x,y,i,j+1,sum+y[j],term);
                 }

             }
             else if(x[i]<y[j])
             {
                 while(i<x.length && y[j]>x[i])
                 {
                     i++;
                 }
                 if(y[j]==x[i]){
                  return   Math.max(findMax(x,y,i,j+1,sum+y[j],term),findMax(x,y,i+1,j,sum+x[i],1));
                 }
                 else
                 {
                     if(i==x.length-1) {
                         while(j<y.length)
                         {
                             sum+=y[j];
                             j++;
                         }
                         return sum;
                     }
                     else
                     {
                         return findMax(x,y,i,j+1,sum+y[j],term);
                     }
                 }
             }
             else if(x[i]==y[j])
             {
              return   Math.max(findMax(x,y,i,j+1,sum+y[j],term),findMax(x,y,i+1,j,sum+x[i],1));
             }
         }

         return -11111;

    }

}

