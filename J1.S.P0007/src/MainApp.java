import common.InOutUtils;
import entity.Graph;

import java.util.Arrays;

public class MainApp {
    private static Graph graph;
    private static int startPoint;
    private static int endPoint;

    public static void main(String[] args) {
        inputEdge();
        initGraph();
        printResult();
    }
    private static void initGraph(){
        graph = new Graph(6);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        graph.addEdge(5,4);
        graph.addEdge(3,5);
        graph.addEdge(2,5);
    }

    public static void inputEdge(){
        InOutUtils.inputInt("Enter the start point: \n", 0, Integer.MAX_VALUE);
        InOutUtils.inputInt("Enter the end point: \n", 0, Integer.MAX_VALUE);
    }
    public static void printResult(){
        if(graph.isEdge(startPoint,endPoint)){
            InOutUtils.printMsg("This is an edge");
        }else{
            InOutUtils.printMsg("This isn't an edge");
        }
    }

}
