
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
        int tempScore=0;
        if (player1Points == player2Points)
        {
            score = getTiedScore();
        }
        else if (player1Points >=4 || player2Points >=4)
        {
            score = getAdvantageOrWinner();
        }
        else
        {
//            for (int i=1; i<3; i++)
//            {
//                score = getNotTieScore(score, i);
//            }

            String player1Score = getPlayerScore(score, player1Points);
            String player2Score = getPlayerScore(score, player2Points);

            score = player1Score + "-" + player2Score;
        }
        return score;
    }

    private String getAdvantageOrWinner() {
        String score;
        int minusResult = player1Points - player2Points;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String getTiedScore() {
        String score;
        switch (player1Points)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }

//    private String getNotTieScore(String score, int i) {
//        int tempScore;
//        if (i ==1) tempScore = player1Score;
//        else { score +="-"; tempScore = player2Score;}
//        return getPlayerScore(score, tempScore);
//    }

    private String getPlayerScore(String score, int playerScore) {
        switch(playerScore)
        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;
        }
        return score;
    }
}
