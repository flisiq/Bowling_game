
package com.example.android.bowling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // if You push a player's button, one of the messages will appear in the red box
    private final String[] flavorGoodLuck = {"Good luck!", "Go on!", "Having fun?", "Who is winning?",
            "Who loses, makes a dinner!", "Next roll will strike!",
            "Have fun!", "You owe me!", "Come on!", "Not bored yet?",
            "Get 'em all!", "Go out to play real bowling!",
            "Don't be too hard on Yourself!",
            "How's Your mood today?", "Let's win!", "Be competitive!", "Roll!",
            "Hit 'em!",
            "Hope You enjoy", "Keep going!", "Great!", "Don't be shy!",
            "I never saw that coming!", "Please, rate me well!",
            "I wish I had more free time!", "Don't fall over!",
            "Do You have bowling boots?",
            "Where did You learn this?!",};
    // this is picked when a player hits strike
    private final String[] flavorStrike = {"Woah, a STRIKE!", "Oh baby, a STRIKE!", "STRIKE!", "STRIKE, excellent!",
            "STRIKE, awesome!", "W1ow, now You will surely win after this STRIKE!",
            "STRIKE, well done!", "A STRIKE, You've got amazing skills!",
            "What?! Impressive STRIKE!", "Impressive STRIKE!",
            "STRIKE, congrats!", "Was that a STRIKE, or just a fantasy?!",
            "A STRIKE, how did You do it?!", "You got them all by a STRIKE!",
            "You startled the opponent with a STRIKE!",};
    // same for a spare
    private final String[] flavorSpare = {"Nice throw, a SPARE!", "Nice SPARE!", "Finally, all of them! SPARE!",
            "And suddenly, a SPARE!", "THat's a SPARE, I am proud!", "Aaaand SPARE!",
            "A handsome SPARE! ", "Oh, You hit a SPARE!", "SPARE! You never miss, eh?",
            "That's what I call a SPARE!", "SPARE, nice!", "Tha was a good SPARE!"};
    /**
     * These are values for player 1
     */

    // Those are scores and ints displayed in app
    private int p1score = 0;
    private int p1strikes = 0;
    private int p1spares = 0;
    //This tracks state of Pins on play
    private int p1numberOfPins = 10;
    private int p1pinsHit = 0;
    //a listener for "Player 1 roll" Button
    private int p1RollButtonListener = 0;
    /**
     * These are Player 2's values
     */

    // Displayables for player 2
    private int p2score = 0;
    private int p2strikes = 0;
    private int p2spares = 0;
    //State of pins
    private int p2pinsHit = 0;
    private int p2numberOfPins = 10;
    private int p2RollButtonListener = 0;
    //keeping track of rounds
    private int round = 1;
    //this appears on the upper part of a red box as header text
    private String headerText = "Player 1 turn, roll 1";
    // This is lower part of the red box, it equals the random text below
    private String flavorText = "Welcome in Ten-pin Bowling game! Tap the " +
            "\" PLAYER 1 ROLL \" button to begin.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshScores();

    }


    /**
     * Displays upper text in the section with a transparent background (header text)
     */
    private void displayHeaderText(String header) {
        TextView scoreView = (TextView) findViewById(R.id.header);
        scoreView.setText(String.valueOf(header));
    }

    /**
     * Displays lower text in the section with a transparent background (flavor text)
     */
    private void displayFlavorText(String flavor) {
        TextView scoreView = (TextView) findViewById(R.id.flavor);
        scoreView.setText(String.valueOf(flavor));
    }

    /**
     * Displays the given score for Player 1.
     */
    private void displayForPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player 2.
     */
    private void displayForPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays round counter.
     */
    private void displayRounds(int rounds) {
        TextView scoreView = (TextView) findViewById(R.id.rounds);
        scoreView.setText(String.valueOf(rounds));
    }

    /**
     * Displays the strikes count for Player 1.
     */
    private void displayStrikesForPlayer1(int strikes) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_strikes);
        scoreView.setText(String.valueOf(strikes));
    }

    /**
     * Displays the strikes count for Player 2.
     */
    private void displayStrikesForPlayer2(int strikes) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_strikes);
        scoreView.setText(String.valueOf(strikes));
    }

    /**
     * Displays the spares count for Player 1.
     */
    private void displaySparesForPlayer1(int strikes) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_spares);
        scoreView.setText(String.valueOf(strikes));
    }

    /**
     * Displays the spares count for Player 2.
     */
    private void displaySparesForPlayer2(int strikes) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_spares);
        scoreView.setText(String.valueOf(strikes));
    }

    /**
     * Contains all "display" functions
     */
    private void refreshScores() {
        displayForPlayer1(p1score);
        displayForPlayer2(p2score);
        displayStrikesForPlayer1(p1strikes);
        displayStrikesForPlayer2(p2strikes);
        displaySparesForPlayer1(p1spares);
        displaySparesForPlayer2(p2spares);
        displayRounds(round);
        displayHeaderText(headerText);
        displayFlavorText(flavorText);
        if (round >=10){ displayRounds(10);}
    }

    /**
     * this engine picks a random string from an array based on its lenght (so it fits any array)
     * @return - returns a numbe of which string is picked by random
     */
    private int stringsRandomizer(int length) {
        double randomNumber = Math.random();
        randomNumber *= length;
        return (int) randomNumber;

    }

    /**
     * simulates a given player's roll
     *
     * @return random number between 0 and 10 (amount of pins hit)
     */
    private int p1rollsim() {

        double randomNumber = Math.random();

        //here I expand Math.random's range to (almost) 11;
        randomNumber *= (p1numberOfPins + 1);

        //so when I cast it into an integer, it will have a max value of 10.

        return (int) randomNumber;
    }

    /**
     * simulates a given player's roll
     *
     * @return random number between 0 and 10 (amount of pins hit)
     */
    private int p2rollsim() {

        double randomNumber = Math.random();

        //here I expand Math.random's range to (almost) 11;
        randomNumber *= (p2numberOfPins + 1);

        //so when I cast it into an integer, it will have a max value of 10.

        return (int) randomNumber;
    }

    /**
     * random engines simulating bowling rolls for player 1 (based on number of pins in play)
     */
    private void player1FirstRoll() {

        // This is an actual throw; randomizes amount of pins hit by You
        p1pinsHit = p1rollsim();

        //Of course we have to know how many pins are left after Your roll
        p1numberOfPins -= p1pinsHit;

        //This calculates score
        p1score += p1pinsHit;

        //seeking for a strike ( which also states that after a strike it's other player's turn now)
        if (p1numberOfPins == 0) {
            p1strikes += 1;
            p1score += 15;
            p1RollButtonListener = 0;

            p1numberOfPins = 10;
            headerText = "Player 2 turn, roll 1";
            //picks a flavor text for a strike (  nameOfArray[number of a picked string, which is a randomization method] )
            flavorText = flavorStrike[stringsRandomizer(flavorStrike.length)];
        } else {

            //This tells the program that a player has made his first roll and tries to hit remaining pins
            p1RollButtonListener = 1;
            headerText = "Player 1 turn, roll 2";
        }


    }
    private void player1SecondRoll() {
    // pretty much the same as a second roll with some changes
        p1pinsHit = p1rollsim();
        p1numberOfPins -= p1pinsHit;
        if (p1numberOfPins == 0) {
            p1spares += 1;
            p1score += 7;
            flavorText = flavorSpare[stringsRandomizer(flavorSpare.length)];
        }
        p1score += p1pinsHit;
        p1numberOfPins = 10;
        p1RollButtonListener = 0;
        headerText = "Player 2 turn, roll 1";
    }


    /**
     * random engines simulating bowling rolls for player 1 (based on number of pins in play)
     */
    // act the same as palyer 1's, but aslo second roll (or a strike) adds 1 to rounds counter
    private void player2FirstRoll() {
        p2pinsHit = p1rollsim();
        p2numberOfPins -= p2pinsHit;
        p2score += p2pinsHit;
        if (p2numberOfPins == 0) {
            p2strikes += 1;
            round += 1;
            p2score += 15;
            p2RollButtonListener = 0;
            p2numberOfPins = 10;
            flavorText = flavorStrike[stringsRandomizer(flavorStrike.length)];
            headerText = "Player 1 turn, roll 1";
        } else {
            p2RollButtonListener = 1;
            headerText = "Player 2 turn, roll 2";
        }
    }
    private void player2SecondRoll() {
        p2pinsHit = p2rollsim();
        p2numberOfPins -= p2pinsHit;
        if (p2numberOfPins == 0) {
            p2spares += 1;
            p2score += 7;
            flavorText = flavorSpare[stringsRandomizer(flavorSpare.length)];
        }
        p2score += p2pinsHit;
        p2numberOfPins = 10;
        p2RollButtonListener = 0;
        round += 1;
        headerText = "Player 1 turn, roll 1";
    }

    /**
     * This contains behaviour of a reset button.
     */
    public void reset(View view) {

        p1score = 0;
        p2score = 0;
        p1strikes = 0;
        p2strikes = 0;
        p1spares = 0;
        p2spares = 0;
        p1numberOfPins = 10;
        p2numberOfPins = 10;
        p1RollButtonListener = 0;
        p2RollButtonListener = 0;
        round = 1;
        headerText = "Player 1 turn, roll 1";
        flavorText = "Welcome in Ten-pin Bowling game! Tap the \" PLAYER 1 ROLL \" button to begin.";
        refreshScores();

    }

    /**
     * "Player 1 Roll" button behavior
     */
    public void player1roll(View view) {
        flavorText = flavorGoodLuck[stringsRandomizer(flavorGoodLuck.length)];

        //It's a condition for an endgame screen
        if (round == 11) {
            winScreen();
            refreshScores();

            // /set only not to interfere with other conditions, but "rounds" TextView displays "10"
            round = 15;

        // This part makes roll buttons unusable if the game is over (You can only reset scores to play again)
        } else if (headerText == "Player 1 WINS!" || headerText == "Player 2 WINS!" &&
                headerText == "Player 2 WINS!" || headerText == "It's a DRAW!") {
            flavorText = "Push the reset button to start over.";
            refreshScores();
        // If above conditions are not met, just rolls the bowling ball :D
        } else if (headerText == "Player 1 turn, roll 1" || headerText == "Player 1 turn, roll 2") {

            // This section checks wether it's a first try of a round to hit all the pins (with strike
            // possibility), or a second roll, where player tries to hit remaining pins.
            if (p1RollButtonListener == 0) {
                player1FirstRoll();
                refreshScores();
            } else {
                player1SecondRoll();
                refreshScores();
            }
        } else {
            // This blocks another player's button if it's not his turn
            flavorText = "Now it's Player 2's turn!";
            refreshScores();
        }

    }

    /**
     * "Player 2 Roll" button behavior
     */
    public void player2roll(View view) {
        flavorText = flavorGoodLuck[stringsRandomizer(flavorGoodLuck.length)];
        if (round == 11) {
            winScreen();
            refreshScores();
            round = 15;
            displayRounds(10);
        } else if (headerText == "Player 1 WINS!" || headerText == "Player 2 WINS!" &&
                headerText == "Player 2 WINS!" || headerText == "It's a DRAW!") {
            flavorText = "Push the reset button to start over.";
            refreshScores();
            displayRounds(10);

        } else if (headerText == "Player 2 turn, roll 1" || headerText == "Player 2 turn, roll 2") {
            if (p2RollButtonListener == 0) {
                player2FirstRoll();
                refreshScores();
            } else {
                player2SecondRoll();
                refreshScores();
            }
        } else {
            flavorText = "Now it's Player 1's turn!";
            refreshScores();
        }
    }

    //This happens when "rounds" count hits 10; then, the match is over and player with ore points wins.
    private void winScreen() {
        if (p1score > p2score) {
            headerText = "Player 1 WINS!";
            flavorText = "Player 1 turned out to be better! Now hit the Reset button to play again.";
        } else if (p1score == p2score) {
            headerText = "It's a DRAW!";
            flavorText = "No one has expected the draw! Now hit the Reset button to play again. ";
        } else {
            headerText = "Player 2 WINS!";
            flavorText = "Player 2 turned out to be better! Now hit the Reset button to play again.";

        }
        refreshScores();

    }
}
