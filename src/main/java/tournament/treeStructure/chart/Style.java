package tournament.treeStructure.chart;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Style {

    @JsonProperty("stroke-width")
    private int strokeWidth = 2;

    @JsonProperty("stroke")
    private String stroke = "#ccc";
}
