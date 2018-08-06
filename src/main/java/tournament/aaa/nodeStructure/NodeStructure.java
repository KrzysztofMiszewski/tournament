package tournament.aaa.nodeStructure;

public class NodeStructure {

    private Text text;
    private String HTMLclass = "";
    private NodeStructure[] children = new NodeStructure[2];

    public NodeStructure() {
    }

    public NodeStructure(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.text = new Text();
        if (name != null) this.text.setName(name);
        else this.text.setName("");
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getHTMLclass() {
        return HTMLclass;
    }

    public void setHTMLclass(String HTMLclass) {
        this.HTMLclass = HTMLclass;
    }

    public NodeStructure[] getChildren() {
        return children;
    }

    public void setChildren(NodeStructure[] children) {
        this.children = children;
    }
}
