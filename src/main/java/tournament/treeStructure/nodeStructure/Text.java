package tournament.treeStructure.nodeStructure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Text {

    private String name;
    private String desc;
    private String title;
    @JsonProperty("data-round")
    private Integer dataRound;
    @JsonProperty("data-game")
    private Integer dataGame;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDataRound() {
        return dataRound;
    }

    public void setDataRound(Integer dataRound) {
        this.dataRound = dataRound;
    }

    public Integer getDataGame() {
        return dataGame;
    }

    public void setDataGame(Integer dataGame) {
        this.dataGame = dataGame;
    }
}


