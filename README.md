# arkanoid

This is the final project in oop class in Bar Ilan Univercity.

Arkanoid is a 1986 block breaker arcade game developed and published by Taito.
In North America, it was published by Romstar.
Controlling a paddle-like craft known as the Vaus, the player is tasked with clearing a formation of colorful blocks by deflecting a ball towards it without letting the ball leave the bottom edge of the playfield.
Some blocks contain power-ups that have various effects, such as increasing the length of the Vaus, creating several additional balls, or equipping the Vaus with cannons.
Other blocks may be indestructible or require multiple hits to break.

## input:
When run without arguments, you will start a game with four levels that run one after the other.
When run with additional arguments, the arguments will be treated as a list of level numbers to run, in the specified order.
Discard (ignore) any argument which is not a number, or not in your levels range.

## There are optional 4 levels:

##### Level 1:
<img width="794" alt="level1" src="https://user-images.githubusercontent.com/116814174/226602819-652ab7eb-0bc2-4736-8f0b-8e94ac75d74d.png">

##### Level 2:
<img width="801" alt="צילום מסך 2023-03-21 ב-14 05 10" src="https://user-images.githubusercontent.com/116814174/226603645-594cd37f-b7bf-4635-a97b-bdca41ffbb63.png">

##### Level 3:
<img width="803" alt="צילום מסך 2023-03-21 ב-14 06 38" src="https://user-images.githubusercontent.com/116814174/226604014-f6822a4c-587e-4479-a386-46a5308c5441.png">

##### Level 4:
<img width="794" alt="צילום מסך 2023-03-21 ב-14 08 49" src="https://user-images.githubusercontent.com/116814174/226604141-5d4d4139-3aa0-4b51-a545-3df04fe93c3c.png">

## How compile and run:

##### 1) By ANT:
compiling the code will work using the command:
      a.ant compile 
     
and running it is with:
      ant run
 
passing arguments to the java run command can be done like this:
      ant -Dargs="1 3 2 1 9 1 bla 3 4 3" run
      
