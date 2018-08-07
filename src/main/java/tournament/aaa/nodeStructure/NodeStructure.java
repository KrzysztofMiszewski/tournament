package tournament.aaa.nodeStructure;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeStructure {

    private Text text;
    private String HTMLclass;
    private Object[] children = new Object[2];

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

    public Object[] getChildren() {
        return children;
    }

    public void setChildren(Object[] children) {
        this.children = children;
    }
}
