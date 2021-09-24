
public class TennisGame1 implements TennisGame {
    
    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Points += 1;
        else
            player2Points += 1;
    }

    public String getScore() {
        String score = "";
        if (player1Points ==  player2Points && player1Points >= 3) {
            score = "Deuce";
        }
        else if (player1Points == player2Points && player1Points < 3)
        {
            score = getPlayerScore(player1Points) + "-All";
        }
        else if (player1Points >=4 || player2Points >=4)
        {
            score = getAdvantageOrWinner();
        }
        else
        {
            String player1Score = getPlayerScore(player1Points);
            String player2Score = getPlayerScore(player2Points);

            score = player1Score + "-" + player2Score;
        }
        return score;
    }

    private String getAdvantageOrWinner() {
        String score;
        int scoreDifference = player1Points - player2Points;
        if (scoreDifference==1) score ="Advantage player1";
        else if (scoreDifference ==-1) score ="Advantage player2";
        else if (scoreDifference>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String getPlayerScore(int playerScore) {
        String score = "";
        switch(playerScore)
        {
            case 0:
                score ="Love";
                break;
            case 1:
                score ="Fifteen";
                break;
            case 2:
                score ="Thirty";
                break;
            case 3:
                score ="Forty";
                break;
        }
        return score;
    }
}
