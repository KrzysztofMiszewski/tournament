package tournament.treeStructure.chart;

public class Chart {

    private String container = "#OrganiseChart6";
    private int levelSeparation = 20;
    private int siblingSeparation = 15;
    private int subTeeSeparation = 15;
    private String rootOrientation = "EAST";

    private Node node = new Node();
    private Connectors connectors = new Connectors();

    public String getContainer() {
        return container;
    }

    public int getLevelSeparation() {
        return levelSeparation;
    }

    public int getSiblingSeparation() {
        return siblingSeparation;
    }

    public int getSubTeeSeparation() {
        return subTeeSeparation;
    }

    public String getRootOrientation() {
        return rootOrientation;
    }

    public Node getNode() {
        return node;
    }

    public Connectors getConnectors() {
        return connectors;
    }
}
