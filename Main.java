import java.text.DecimalFormat;
class Main
{
   private int vertices;
   private double Q[][];
   private double Qold[][];
   private int R[][];
   private int goalState = 5;
    //private int count=0;
    Main(int v)
   {
       vertices= v;
       Q = new double[vertices][vertices];
       Qold = new double[vertices][vertices];
       R =new int[vertices][vertices];
       for(int i =0;i<vertices;i++)
       {
         for(int j =0;j<vertices;j++)
         {
           R[i][j] =-1;
         }
       }
   }
   void addEdge(int vertex1,int vertex2,int cost)
   {
       R[vertex1][vertex2] = cost;
   } 
   void printQ()
   {
     System.out.println("********************");
     for(int i =0;i<vertices;i++)
     {
 
     for(int j =0;j<vertices;j++)
     {
      System.out.print(new DecimalFormat("#.#").format(Q[i][j])+" ");
     
     }
     System.out.println();
     }
     System.out.println("********************");
   }
 
   double difference(double[][] matrix1, double[][]matrix2)
   {
     double Difference =0;
       for(int i =0;i<vertices;i++)
       {
         for(int j =0;j<vertices;j++)
         {
           Difference += Math.abs(matrix1[i][j] -matrix2[i][j]);
         }
       }
       return Difference;
   }
   double maxOfNextState(int state)
   {
     double maxvalue =0;
     for(int i =0;i<vertices;i++)
     {
       if(Q[state][i] >maxvalue)
         maxvalue = Q[state][i];
     }
     return maxvalue;
   }
   int randomgen()
   {
     double x = Math.random()*5;
     return (int)Math.round(x);
   }
   void copyNewToOld()
   {
     for(int i=0; i<vertices; i++)
     for(int j=0; j<vertices; j++)
     Qold[i][j]=Q[i][j];
   }
   void calculateQ(int alpha)
   {
         
          int initialState;
          int nextState;
          printQ();
          do
          {
             copyNewToOld();
             initialState = randomgen();
             System.out.println(alpha+".");
             System.out.println("initialS: "+initialState);
             do
             {
              
               nextState = randomgen();
               while(R[initialState][nextState]==-1)
               {
                  nextState = randomgen();
               }
               System.out.println("nextS: "+nextState);
               Q[initialState][nextState] = R[initialState][nextState] +0.8*maxOfNextState(nextState);
               initialState = nextState;
             }while(nextState !=goalState);
             printQ();
          }while(alpha-->=0);//while(difference(Q,Qold)>=10);
          normalize();
          printQ();
   }
    public static void main(String args[])
   {
       Main g = new Main(6);
        g.addEdge(0,4,0);
       g.addEdge(4,0,0);
       g.addEdge(4,3,0);
       g.addEdge(4,5,100);
       g.addEdge(2, 3,0);
       g.addEdge(3,2,0);
       g.addEdge(3,4,0);
       g.addEdge(3,1,0);
       g.addEdge(1,3,0);
       g.addEdge(1,5,100);
       g.addEdge(5,5,100);
       g.addEdge(5,1,0);
       g.addEdge(5,4,100);
       g.calculateQ(100);
	   g.find();
	   g.find();
	   g.find();
	   g.find();
      
   }
   void  normalize()
   {
     double max =0;
     for(int i =0;i<vertices;i++)
     {
       for(int j =0;j<vertices;j++)
       {
         if (Q[i][j]> max)
          max = Q[i][j];
       }
     }
     for(int i =0;i< vertices; i++)
     {
       for(int j =0;j<vertices;j++)
       {
         Q[i][j] =Q[i][j]/max;
       }
     }
   }
   int findhighestneighbor(int a)
   {
	   double max =0;
	   int p =0;
	   for(int i =0;i<vertices;i++)
	   {
		   if (Q[a][i]>= max)
		   {
			   max = Q[a][i];
			   p = i;
		   }
	   }
	   return p;
   }
   void find()
   {
	   int initial = randomgen();
	   System.out.print(initial);
	   while(initial!=goalState)
	   {
		   int nextState =findhighestneighbor(initial);
		   System.out.print("->"+nextState);
		   initial= nextState;
	   }
	   System.out.println();
	   System.out.println();
   }
}
