package tournament.aaa.chart;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Node {

    @JsonProperty("HTMLclass")
    private String htmlclass = "game";

    private boolean drawLineThrough = true;

    public String getHtmlclass() {
        return htmlclass;
    }

    public boolean isDrawLineThrough() {
        return drawLineThrough;
    }
}
