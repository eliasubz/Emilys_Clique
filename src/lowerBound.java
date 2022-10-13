import java.util.*;

    public class lowerBound {

        static int edgesVertices = 2, verticesNumber = 3;//edgesVertices = 303, verticesNumber = 76;
        // Stores the vertices
        static int []points = new int[edgesVertices];// has the amount of edges
        static int [][]graph = new int[verticesNumber][verticesNumber]; //CHANGE EDGESvERTICES TO VERTICES NUMBEREgraph matrix 303 * 303 edges times edges
        // Degree of the vertices
        static int []d = new int[verticesNumber]; // Change again to have an array for every vertix and how man conections t has


        public static void main(String[] args) {
            // edgesNumber = 46;
            // verticesNumber = 76;
            System.out.println(Arrays.deepToString(graph));
            // testing graph 1
            int [][]edges = { {1, 2}, { 1, 3}};//, { 1, 3}};//{53, 33}, { 53, 61}, { 53, 66}, { 53, 47}, { 69, 71}, { 53, 39}, { 53, 58}, { 53, 3}, { 53, 56}, { 53, 22}, { 53, 12}, { 53, 48}, { 53, 16}, { 53, 65}, { 53, 27}, { 53, 76}, { 53, 46}, { 53, 40}, { 53, 63}, { 72, 29}, { 72, 46}, { 72, 6}, { 72, 61}, { 72, 69}, { 72, 14}, { 72, 37}, { 72, 62}, { 72, 28}, { 2, 7}, { 2, 49}, { 2, 46}, { 2, 76}, { 61, 66}, { 61, 76}, { 61, 27}, { 61, 63}, { 61, 65}, { 61, 45}, { 61, 54}, { 61, 67}, { 61, 52}, { 61, 36}, { 61, 29}, { 61, 46}, { 61, 70}, { 61, 14}, { 61, 6}, { 61, 9}, { 61, 38}, { 61, 51}, { 61, 62}, { 61, 43}, { 61, 10}, { 61, 50}, { 61, 28}, { 12, 47}, { 12, 39}, { 12, 58}, { 12, 3}, { 12, 56}, { 12, 22}, { 12, 48}, { 12, 63}, { 12, 46}, { 68, 44}, { 68, 42}, { 68, 1}, { 68, 31}, { 68, 60}, { 68, 23}, { 68, 55}, { 68, 46}, { 26, 11}, { 4, 35}, { 4, 33}, { 4, 76}, { 4, 49}, { 4, 15}, { 4, 34}, { 4, 19}, { 76, 66}, { 76, 40}, { 76, 16}, { 76, 18}, { 76, 63}, { 76, 35}, { 76, 33}, { 76, 15}, { 76, 34}, { 76, 19}, { 76, 7}, { 76, 49}, { 76, 27}, { 76, 46}, { 16, 40}, { 16, 63}, { 16, 46}, { 56, 47}, { 56, 39}, { 56, 58}, { 56, 3}, { 56, 22}, { 56, 48}, { 56, 63}, { 56, 46}, { 51, 46}, { 51, 70}, { 51, 14}, { 51, 6}, { 51, 9}, { 51, 38}, { 51, 62}, { 51, 28}, { 39, 47}, { 39, 58}, { 39, 3}, { 39, 22}, { 39, 48}, { 39, 63}, { 39, 46}, { 35, 33}, { 35, 49}, { 35, 15}, { 35, 34}, { 35, 19}, { 13, 27}, { 13, 46}, { 41, 8}, { 41, 46}, { 31, 21}, { 31, 24}, { 31, 44}, { 31, 42}, { 31, 1}, { 31, 60}, { 31, 23}, { 31, 55}, { 31, 46}, { 19, 27}, { 19, 33}, { 19, 49}, { 19, 15}, { 19, 59}, { 19, 34}, { 19, 46}, { 67, 45}, { 67, 46}, { 67, 54}, { 67, 70}, { 67, 52}, { 67, 36}, { 67, 62}, { 67, 28}, { 55, 44}, { 55, 42}, { 55, 1}, { 55, 60}, { 55, 23}, { 55, 46}, { 1, 44}, { 1, 42}, { 1, 60}, { 1, 23}, { 1, 46}, { 27, 33}, { 27, 66}, { 27, 63}, { 27, 18}, { 27, 65}, { 27, 30}, { 27, 57}, { 27, 62}, { 27, 28}, { 27, 5}, { 27, 46}, { 42, 24}, { 42, 44}, { 42, 60}, { 42, 23}, { 42, 46}, { 59, 34}, { 59, 5}, { 59, 46}, { 48, 47}, { 48, 58}, { 48, 3}, { 48, 22}, { 48, 63}, { 48, 46}, { 36, 45}, { 36, 46}, { 36, 54}, { 36, 70}, { 36, 62}, { 36, 28}, { 36, 52}, { 36, 6}, { 58, 47}, { 58, 3}, { 58, 22}, { 58, 63}, { 58, 46}, { 24, 46}, { 34, 33}, { 34, 49}, { 34, 15}, { 34, 46}, { 43, 10}, { 25, 63}, { 60, 44}, { 60, 23}, { 60, 46}, { 73, 20}, { 73, 32}, { 17, 54}, { 17, 46}, { 17, 62}, { 17, 28}, { 64, 40}, { 64, 63}, { 15, 33}, { 15, 49}, { 23, 44}, { 23, 46}, { 3, 47}, { 3, 22}, { 3, 63}, { 3, 46}, { 28, 45}, { 28, 54}, { 28, 70}, { 28, 52}, { 28, 29}, { 28, 69}, { 28, 14}, { 28, 37}, { 28, 6}, { 28, 9}, { 28, 38}, { 28, 62}, { 28, 46}, { 5, 46}, { 14, 9}, { 14, 38}, { 14, 70}, { 14, 69}, { 14, 37}, { 14, 62}, { 33, 46}, { 33, 63}, { 33, 49}, { 50, 10}, { 29, 46}, { 29, 6}, { 29, 62}, { 9, 46}, { 9, 70}, { 9, 6}, { 9, 38}, { 9, 62}, { 20, 32}, { 63, 66}, { 63, 47}, { 63, 22}, { 63, 46}, { 63, 40}, { 22, 47}, { 22, 46}, { 37, 69}, { 37, 62}, { 49, 7}, { 49, 46}, { 7, 46}, { 74, 46}, { 46, 47}, { 46, 66}, { 46, 18}, { 46, 40}, { 46, 45}, { 46, 54}, { 46, 70}, { 46, 52}, { 46, 6}, { 46, 38}, { 46, 62}, { 46, 44}, { 46, 8}, { 52, 45}, { 52, 54}, { 52, 70}, { 52, 62}, { 62, 45}, { 62, 54}, { 62, 70}, { 62, 69}, { 62, 6}, { 62, 38}, { 54, 45}, { 54, 70}, { 6, 38}, { 38, 70}, { 45, 70}, { 10, 75} };

            int size = edges.length;

            for (int i = 0; i < size; i++) {
                System.out.println(i);
                graph[edges[i][0]-1][edges[i][1]-1] = 1;// graph [[0][0] = 1][[0][1] = 2]->[1][2] = 1 has to be 0 for first index in graph
                graph[edges[i][1]-1][edges[i][0]-1] = 1;// graph[
                //System.out.println(edges[i][0] + " " + edges[i][1]);
                d[edges[i][0]-1]++; // adds 1 to d[0] because edges[i=0] points to {1,2}
                d[edges[i][1]-1]++;// adds 1 to d[1]
                System.out.println(Arrays.toString(d));
                System.out.println(Arrays.deepToString(graph));
            }
            System.out.println("for loop builds d: [2, 2, 2]\ngraph: [[0, 1, 1], [1, 0, 1], [1, 1, 0]]");

            //System.out.println(Arrays.deepToString(graph));
            System.out.println("\n" + maxCliques(0, 1));
        }


        // Checks if the set of vertices in the array is a clique
        static boolean isClique(int x)
        {

            // Run a loop for all set of edges
            for (int u = 1; u < x; u++) {
                for (int v = u + 1; v < x; v++)
                    // If any edge is missing
                    if (graph[points[u]][points[v]] == 0)
                        return false;
            }
            return true;
        }

        // Function to find all the sizes of max cliques
        static int maxCliques(int u, int y) {

            int maxNum = 0;

            // Checks if any vertices from i+1 can be added
            for (int v = u + 1; v <= verticesNumber; v++) {

                points[y] = v;                                  // recusion 0/: point[1/ edges] = 1
                if (isClique(y + 1)) {
                    //System.out.println("this is y: "+y+"\nthis is v: "+ v);

                    // Update max and checks if another edge can be added
                    maxNum = Math.max(maxNum, y);
                    maxNum = Math.max(maxNum, maxCliques(v, y + 1));
                }
            }
            return maxNum;
        }
    }
