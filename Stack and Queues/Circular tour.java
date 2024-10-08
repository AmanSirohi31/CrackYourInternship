class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
        int st = 0;
        int rear = 0;
        int deficiency = 0;
        int balance = 0;
        for(int i=0; i<petrol.length; i++){
            balance+=petrol[i]-distance[i];
            if(balance<0){
                deficiency+=balance;
                st = i+1;
                balance=0;
            }
        }
        if(deficiency+balance>=0){
            return st;
        }
        return -1;
		
    }
}
