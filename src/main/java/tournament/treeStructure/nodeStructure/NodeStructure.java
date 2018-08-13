package tournament.treeStructure.nodeStructure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeStructure {

    private Text text = new Text();
    @JsonProperty("HTMLclass")
    private String htmlClass;
    private Object[] children = new Object[2];

    public NodeStructure() {
    }

    public NodeStructure(String name) {
        setName(name);
    }

    public void setName(String name) {
//        this.text = new Text();
//        if (name != null) this.text.setName(name);
//        else this.text.setName("");
        text.setName(name);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
    public String getHtmlClass() {
        return htmlClass;
    }
    public void setHtmlClass(String htmlClass) {
        this.htmlClass = htmlClass;
    }

    public Object[] getChildren() {
        return children;
    }

    public void setChildren(Object[] children) {
        this.children = children;
    }
}
