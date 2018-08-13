package tournament.treeStructure.nodeStructure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LastNode {

    private Text text;
    @JsonProperty("HTMLclass")
    private String htmlClass;

    public LastNode() {
    }

    public LastNode(String name, String htmlClass) {
        setName(name);
        this.htmlClass = htmlClass;
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

    public String getHtmlClass() {
        return htmlClass;
    }

    public void setHtmlClass(String htmlClass) {
        this.htmlClass = htmlClass;
    }

}