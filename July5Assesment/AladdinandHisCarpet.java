public class AladdinandHisCarpet {
    public static int firstPoint(int[] magic, int[] dist) {
        int n = magic.length;  
        int startPoint = 0;    
    
        while (startPoint < n) {
            int it = startPoint;   
            int mag = magic[startPoint];   
            
            do {
                mag -= dist[it];  
                if (mag < 0) {
                    // If magic falls below zero, move to the next starting point
                    it++;
                    break;
                } else {
                    // Move to the next point in a circular manner
                    it = (it + 1) % n;
                    mag += magic[it];   
                }
            } while (it != startPoint);  // Continue until we return to the starting point
            
            // If we have returned to the starting point, this is the solution
            if (it == startPoint) {
                return startPoint;
            }
            
            // Move to the next possible starting point
            startPoint++;
        }
        
        return -1;
    }
    public static void main(String[] args) {
        int[] magic1 = new int[]{2,4,5,2};
        int[] dist1 = new int []{4,3,1,3};

        int[] magic2 = new int[]{3,2,5,4};
        int[] dist2 = new int []{2,3,4,2};


        int[] magic3 = new int[]{1,2,2,1,2,3};
        int[] dist3 = new int []{2,3,4,4,5,6};

        int[] magic4 = new int[]{10,1,17,4,7,5};
        int[] dist4 = new int []{11,3,2,2,3,4};


        System.out.println(firstPoint(magic1, dist1));
        System.out.println(firstPoint(magic2, dist2));
        System.out.println(firstPoint(magic3, dist3));
        System.out.println(firstPoint(magic4, dist4));


    }
}