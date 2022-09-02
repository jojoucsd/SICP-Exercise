https://github.com/jojoucsd/blackjack

'Stop at 17 'Write a strategy called stop-at-17 It should hit for as long as the hand is worth (strictly) less than 17

Test strategies
Write a procedure that takes a player-strategy a house-strategy and a number n of games to play and returns how many the player won that lets you know what fraction of the games was won by the player

(when I did it (test-strategy stop-at-17 stop-at-17 100000) was about 0.41)

'Stop at n'
Write a procedure called stop-at-n that takes a number and returns a strategy that will stop when it gets higher than that number (so stop-at-17 should be 'the same' as (stop-at-n 17))

'Watched'
Write a procedure called watched that takes a strategy and returns a strategy that behaves the same way only also prints (as a side-effect) the arguments it was called with (hand and up-card) and the decision to hit or not

Taking into account the dealers hand
Take a look at Basic Strategy in the Wikipedia Article

You can see that if we take into account the dealers hand that you should stop at 13 if their card is 6 or less, write a strategy that does this (maybe you can use other strategies you have created)