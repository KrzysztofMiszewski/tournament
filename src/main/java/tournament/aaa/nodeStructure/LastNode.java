package tournament.aaa.nodeStructure;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LastNode {

    private Text text;
    private String HTMLclass = "";

    public LastNode() {
    }

    public LastNode(String name) {
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

}