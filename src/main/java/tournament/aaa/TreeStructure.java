package tournament.aaa;

import tournament.aaa.chart.Chart;
import tournament.aaa.nodeStructure.NodeStructure;
import tournament.model.Game;
import tournament.model.Tournament;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class TreeStructure {

    private Chart chart = new Chart();
    private NodeStructure nodeStructure;

    public TreeStructure(Tournament tournament) {
        List<Game> sortedGames = tournament.getGames().stream()
                .sorted(comparingInt(Game::getRound).thenComparingInt(Game::getGameNumber))
                .collect(toList());
        List<NodeStructure> nodeStructures = new ArrayList<>();
        for (int i = 0; i < sortedGames.size(); i++) {
            nodeStructures.add(new NodeStructure());
        }
        for (int i = 0; i < nodeStructures.size()/2; i++) {
            nodeStructures.get(i).getChildren()[0] = nodeStructures.get(2*i + 1);
            nodeStructures.get(i).getChildren()[1] = nodeStructures.get(2*i + 2);
        }
        for (int i = 0; i < nodeStructures.size(); i++) {
            nodeStructures.get(i).setName(sortedGames.get(i).getWinner());
        }
        for (int i = (nodeStructures.size() / 2); i < nodeStructures.size(); i++) {
            nodeStructures.get(i).getChildren()[0] = new NodeStructure(sortedGames.get(i).getWhite().getNick());
            if (sortedGames.get(i).getBlack() != null)
                nodeStructures.get(i).getChildren()[1] = new NodeStructure(sortedGames.get(i).getBlack().getNick());
            else nodeStructures.get(i).getChildren()[1] = new NodeStructure("bye");
        }
        this.nodeStructure = nodeStructures.get(0);
    }

    public Chart getChart() {
        return chart;
    }

    public NodeStructure getNodeStructure() {
        return nodeStructure;
    }
}
